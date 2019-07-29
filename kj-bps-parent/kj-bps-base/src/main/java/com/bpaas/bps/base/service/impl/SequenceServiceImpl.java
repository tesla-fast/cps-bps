package com.bpaas.bps.base.service.impl;

import com.bpaas.bps.base.po.gnr.GnrSequencesPo;
import com.bpaas.bps.base.service.SequenceService;
import com.bpaas.bps.base.service.SequencesCache;
import com.bpaas.bps.common.utils.BaseUtil;
import com.bpaas.bps.common.utils.ConnectionResourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description:
 * @version: 1.0
 */
@Service("sequenceService")
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequencesCache sequencesCache;

    private static final String PREFIX_USER_ID = "UR";
    private static final String PREFIX_POT_ACCT_MAIN_NO = "331"; // 331：通用积分类型
    private static final String PREFIX_POT_ACCT_GROW_NO = "333"; // 333：成长积分类型
    
    /**
     * 每个序列一个锁
     */
    private final Map<String, Lock> lockMap = new ConcurrentHashMap<String, Lock>();

    @Override
    public String generateUserId() {
        return PREFIX_USER_ID + BaseUtil.leftPad("0", generateSeq("USER_ID"), 12);
    }

    @Override
    public String generateSeq(String key) {
        return String.valueOf(generateSequence(key));
    }

    /**
     * 从缓存获取序列
     */
    protected final Long generateSequence(String sequenceName) {
        // 每个序列一个锁
        Lock lock = lockMap.get(sequenceName);
        if (lock == null) {
            synchronized (lockMap) {
                lock = lockMap.get(sequenceName);
                if (lock == null) {
                    lock = new ReentrantLock();
                    lockMap.put(sequenceName, lock);
                }
            }
        }
        Connection conn = ConnectionResourceHolder.getConnection();
        lock.lock();
        try {
            Long[] seq = sequencesCache.getSequenceCache(sequenceName);
            // 在超过缓存时不立即去数据库获取新的序列，因为可能最后这个缓存值用完后，
            // 后续没有再用了，而因其它原因需要重启应用，这是为了防止丢失更多的序列
            if (seq == null || seq[0] > seq[1]) {
                ConnectionResourceHolder.unbound();// 启用新的事务
                GnrSequencesPo gs = sequencesCache.updateGnrSequence(sequenceName);
                seq = new Long[]{gs.getCurrval(), gs.getNextval() - 1};
            }
            Long result = seq[0];
            seq[0]++;
            sequencesCache.retsetSequenceCache(sequenceName, seq);
            return result;
        } finally {
            ConnectionResourceHolder.bound(conn);
            lock.unlock();
        }
    }

	@Override
	public String generatePotAcctMainNo() {
		return PREFIX_POT_ACCT_MAIN_NO + BaseUtil.leftPad("0", generateSeq("POT_ACCT_NO"), 16);
	}

	@Override
	public String generatePotAcctGrowNo() {
		return PREFIX_POT_ACCT_GROW_NO + BaseUtil.leftPad("0", generateSeq("POT_ACCT_NO"), 16);
	}
	
}
