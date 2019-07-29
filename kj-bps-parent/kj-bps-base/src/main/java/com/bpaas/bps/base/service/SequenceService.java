package com.bpaas.bps.base.service;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description:
 * @version: 1.0
 */
public interface SequenceService {

    /**
     * @return
     * @descrption 获取用户号
     */
    public String generateUserId();

    /**
     * @param key
     * @return
     * @descrption 按序列名生成序列
     */
    public String generateSeq(String key);
    
    /**
     * @return
     * @descrption 生成通用积分账号
     */
    public String generatePotAcctMainNo();

    /**
     * @return
     * @descrption 生成成长积分账号
     */
    public String generatePotAcctGrowNo();
}
