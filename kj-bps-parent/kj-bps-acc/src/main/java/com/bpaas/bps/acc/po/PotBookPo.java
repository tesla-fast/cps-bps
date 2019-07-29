package com.bpaas.bps.acc.po;

public class PotBookPo {
	//alias
	public static final String TABLE_ALIAS = "积分账户信息表";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_POT_ACCT_NO = "积分账号";
	public static final String ALIAS_POT_ACCT_TYPE = "积分账户类型 0：通用积分账户 1：专项积分账户（暂未使用） 2：成长积分账户";
	public static final String ALIAS_POT_ACCT_NAME = "积分账户名称";
	public static final String ALIAS_POT_ACCT_STAT = "积分账户状态";
	public static final String ALIAS_OPEN_BRC = "开户机构";
	public static final String ALIAS_OPEN_DATE = "开户日期";
	public static final String ALIAS_POT_ACCT_BAL = "积分余额";
	public static final String ALIAS_DATELASTMAINT = "最后维护时间";
	public static final String ALIAS_REMARK1 = "备用1";
	public static final String ALIAS_REMARK2 = "备用2";
	public static final String ALIAS_REMARK3 = "备用3";
	public static final String ALIAS_E_CARD_NO = "一账通账号";
	
	private String id;
	//columns START
    /**
     * 用户ID       db_column: USER_ID 
     */ 	
	private java.lang.String userId;
    /**
     * 积分账号       db_column: POT_ACCT_NO 
     */ 	
	private java.lang.String potAcctNo;
    /**
     * 积分账户类型 0：通用积分账户 1：专项积分账户（暂未使用） 2：成长积分账户       db_column: POT_ACCT_TYPE 
     */ 	
	private java.lang.String potAcctType;
    /**
     * 积分账户名称       db_column: POT_ACCT_NAME 
     */ 	
	private java.lang.String potAcctName;
    /**
     * 积分账户状态       db_column: POT_ACCT_STAT 
     */ 	
	private java.lang.String potAcctStat;
    /**
     * 开户机构       db_column: OPEN_BRC 
     */ 	
	private java.lang.String openBrc;
    /**
     * 开户日期       db_column: OPEN_DATE 
     */ 	
	private java.util.Date openDate;
    /**
     * 积分余额       db_column: POT_ACCT_BAL 
     */ 	
	private java.math.BigDecimal potAcctBal;
    /**
     * 最后维护时间       db_column: DATELASTMAINT 
     */ 	
	private java.util.Date datelastmaint;
    /**
     * 备用1       db_column: REMARK1 
     */ 	
	private java.lang.String remark1;
    /**
     * 备用2       db_column: REMARK2 
     */ 	
	private java.lang.String remark2;
    /**
     * 备用3       db_column: REMARK3 
     */ 	
	private java.lang.String remark3;
	//columns END
	/**
     * 一账通账号       db_column: REMARK3 
     */ 	
	private java.lang.String eCardNo;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public java.lang.String getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.String value) {
		this.userId = value;
	}
	
	
	public java.lang.String getPotAcctNo() {
		return this.potAcctNo;
	}
	
	public void setPotAcctNo(java.lang.String value) {
		this.potAcctNo = value;
	}
	
	
	public java.lang.String getPotAcctType() {
		return this.potAcctType;
	}
	
	public void setPotAcctType(java.lang.String value) {
		this.potAcctType = value;
	}
	
	
	public java.lang.String getPotAcctName() {
		return this.potAcctName;
	}
	
	public void setPotAcctName(java.lang.String value) {
		this.potAcctName = value;
	}
	
	
	public java.lang.String getPotAcctStat() {
		return this.potAcctStat;
	}
	
	public void setPotAcctStat(java.lang.String value) {
		this.potAcctStat = value;
	}
	
	
	public java.lang.String getOpenBrc() {
		return this.openBrc;
	}
	
	public void setOpenBrc(java.lang.String value) {
		this.openBrc = value;
	}
	
	
	public java.util.Date getOpenDate() {
		return this.openDate;
	}
	
	public void setOpenDate(java.util.Date value) {
		this.openDate = value;
	}
	
	
	public java.math.BigDecimal getPotAcctBal() {
		return this.potAcctBal;
	}
	
	public void setPotAcctBal(java.math.BigDecimal value) {
		this.potAcctBal = value;
	}
	
	
	public java.util.Date getDatelastmaint() {
		return this.datelastmaint;
	}
	
	public void setDatelastmaint(java.util.Date value) {
		this.datelastmaint = value;
	}
	
	
	public java.lang.String getRemark1() {
		return this.remark1;
	}
	
	public void setRemark1(java.lang.String value) {
		this.remark1 = value;
	}
	
	
	public java.lang.String getRemark2() {
		return this.remark2;
	}
	
	public void setRemark2(java.lang.String value) {
		this.remark2 = value;
	}
	
	
	public java.lang.String getRemark3() {
		return this.remark3;
	}
	
	public void setRemark3(java.lang.String value) {
		this.remark3 = value;
	}

	public java.lang.String geteCardNo() {
		return eCardNo;
	}

	public void seteCardNo(java.lang.String eCardNo) {
		this.eCardNo = eCardNo;
	}
	
}

