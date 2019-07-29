package com.bpaas.bps.base.service.impl;

import com.bpaas.bps.base.mapper.GnrSeqMapper;
import com.bpaas.bps.base.po.gnr.GnrSequencesPo;
import com.bpaas.bps.base.service.SequencesCache;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/21
 * @Description:
 * @version: 1.0
 */
@Service("sequencesCache")
public class SequencesCacheImpl implements SequencesCache {
    @Autowired
    private GnrSeqMapper gnrSeqMapper;

    /**
     * 序列缓存池 ，数组第一个值为 下一个值 ， 第二个值为最大值
     */
    private static final Map<String, Long[]> sequenceMap = new ConcurrentHashMap<String, Long[]>();

    /**
     * 重设序列缓存
     */
    public void retsetSequenceCache(String sequenceName, Long[] sequenceCache) {
        sequenceMap.put(sequenceName, sequenceCache);
    }


    /**
     * 获取序列缓存
     */
    public Long[] getSequenceCache(String sequenceName) {
        return sequenceMap.get(sequenceName);
    }

    @Override
    public GnrSequencesPo updateGnrSequence(String sequenceName) {

        GnrSequencesPo gs = new GnrSequencesPo();
        gs.setName(sequenceName);
        gnrSeqMapper.update(gs);// 因不支持select for update 此方法用于加锁
        GnrSequencesPo gnrSequences = gnrSeqMapper.select(gs);

        if (gnrSequences == null) {
            throw new NullPointerException("表T_GNR_SEQUENCES找不到记录[" + sequenceName + "]");
        }

        Long nextval = gnrSequences.getNextval();
        Long increase = gnrSequences.getIncrease();
        Long maxval = gnrSequences.getMaxval();

        // 已达到序列的最大值
        if (nextval > maxval) {
            // 序列循环
            if ("1".equals(gnrSequences.getCycle())) {
                nextval = gnrSequences.getInitval();
            } else {
                // 不循环 返回错误
                throw new PersistenceException("已达到序列的最大值");
            }
        }

        gs.setCurrval(nextval);
        gs.setNextval((nextval + increase) > maxval ? (maxval + 1) : (nextval + increase));

        int rowAffected = gnrSeqMapper.update(gs);
        if (rowAffected != 1) {
            throw new PersistenceException("更新数据失败,Rows Affected " + rowAffected);
        }

        return gnrSequences;
    }
}
