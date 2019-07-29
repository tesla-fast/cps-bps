package com.bpaas.bps.common.constants;

/**
 * 数据库对应的常量
 * 
 * 
 */
public interface Constants_acc {
	
	/** 账户状态[正常-0] */
	public static final String E_ACCT_STAT_0 = "0";
	/** 账户状态[待激活-1] */
	public static final String E_ACCT_STAT_1 = "1";
	/** 账户状态[睡眠-3] */
	public static final String E_ACCT_STAT_3 = "3";
	/** 账户状态[ 注销-9] */
	public static final String E_ACCT_STAT_9 = "9";
	/** 冻结状态[0：正常] */
	public static final String FRZ_STAT_0 = "0";
	/** 冻结状态[4：冻结] */
	public static final String FRZ_STAT_4 = "4";
	/** 一账通账户认证级别[弱实名认证-01] */
	public static final String E_ACCT_CERT_LEVEL_01 = "01";
	/** 一账通账户认证级别[强实名认证-02] */
	public static final String E_ACCT_CERT_LEVEL_02 = "02";
	/**用户认证等级01：已注册*/
    public static final String USER_CERT_LEVEL_01 = "01";
    /**用户认证等级02：已实名认证*/
    public static final String USER_CERT_LEVEL_02 = "02";
    /**用户认证等级03：已绑卡*/
    public static final String USER_CERT_LEVEL_03 = "03";
	/**交易码*/
	String TRANS_CODE = "transCode";
}
