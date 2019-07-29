package com.bpaas.bps.base.service;

import com.bpaas.bps.base.po.gnr.GnrSequencesPo;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description:
 * @version: 1.0
 */
public interface SequencesCache {

    /**
     * 更新序列后获取最新的序列
     *
     * @param sequenceName
     * @return
     */
    public abstract GnrSequencesPo updateGnrSequence(String sequenceName);

    /**
     * 重设序列缓存
     */
    public abstract void retsetSequenceCache(String sequenceName, Long[] sequenceCache);

    /**
     * 获取序列缓存
     */
    public abstract Long[] getSequenceCache(String sequenceName);
}
