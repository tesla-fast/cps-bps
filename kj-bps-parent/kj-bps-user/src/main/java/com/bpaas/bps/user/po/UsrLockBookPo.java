package com.bpaas.bps.user.po;

public class UsrLockBookPo {

    /**
     * 锁定时间       db_column: LOCK_TIME 
     */ 	
	private java.util.Date lockTime;
    /**
     * 用户ID       db_column: USER_ID 
     */ 	
	private java.lang.String userId;
    /**
     * 锁定标志       db_column: LOCK_FLAG 
     */ 	
	private java.lang.String lockFlag;
    /**
     * 锁定功能       db_column: LOCK_FUNCTION 
     */ 	
	private java.lang.String lockFunction;
    /**
     * 锁定方式       db_column: LOCK_WAY 
     */ 	
	private java.lang.String lockWay;
    /**
     * 锁定来源       db_column: LOCK_SOURCE 
     */ 	
	private java.lang.String lockSource;
    /**
     * 锁定原因       db_column: LOCK_REASON 
     */ 	
	private java.lang.String lockReason;
    /**
     * 锁定操作员       db_column: LOCK_OPER 
     */ 	
	private java.lang.String lockOper;
    /**
     * 锁定时效       db_column: LOCK_MODE 
     */ 	
	private java.lang.String lockMode;
    /**
     * 临时锁定持续时间(小时)       db_column: PART_LOCK_HOUR 
     */ 	
	private java.lang.Integer partLockHour;
    /**
     * 解锁时间       db_column: UNLOCK_TIME 
     */ 	
	private java.util.Date unlockTime;
    /**
     * 解锁操作员       db_column: UNLOCK_OPER 
     */ 	
	private java.lang.String unlockOper;
    /**
     * 解锁原因       db_column: UNLOCK_REASON 
     */ 	
	private java.lang.String unlockReason;
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


	
	
	public java.util.Date getLockTime() {
		return this.lockTime;
	}
	
	public void setLockTime(java.util.Date value) {
		this.lockTime = value;
	}
	
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.String value) {
		this.userId = value;
	}
	
	
	public java.lang.String getLockFlag() {
		return this.lockFlag;
	}
	
	public void setLockFlag(java.lang.String value) {
		this.lockFlag = value;
	}
	
	
	public java.lang.String getLockFunction() {
		return this.lockFunction;
	}
	
	public void setLockFunction(java.lang.String value) {
		this.lockFunction = value;
	}
	
	
	public java.lang.String getLockWay() {
		return this.lockWay;
	}
	
	public void setLockWay(java.lang.String value) {
		this.lockWay = value;
	}
	
	
	public java.lang.String getLockSource() {
		return this.lockSource;
	}
	
	public void setLockSource(java.lang.String value) {
		this.lockSource = value;
	}
	
	
	public java.lang.String getLockReason() {
		return this.lockReason;
	}
	
	public void setLockReason(java.lang.String value) {
		this.lockReason = value;
	}
	
	
	public java.lang.String getLockOper() {
		return this.lockOper;
	}
	
	public void setLockOper(java.lang.String value) {
		this.lockOper = value;
	}
	
	
	public java.lang.String getLockMode() {
		return this.lockMode;
	}
	
	public void setLockMode(java.lang.String value) {
		this.lockMode = value;
	}

	public java.lang.Integer getPartLockHour() {
		return partLockHour;
	}

	public void setPartLockHour(java.lang.Integer partLockHour) {
		this.partLockHour = partLockHour;
	}

	public java.util.Date getUnlockTime() {
		return this.unlockTime;
	}
	
	public void setUnlockTime(java.util.Date value) {
		this.unlockTime = value;
	}
	
	
	public java.lang.String getUnlockOper() {
		return this.unlockOper;
	}
	
	public void setUnlockOper(java.lang.String value) {
		this.unlockOper = value;
	}
	
	
	public java.lang.String getUnlockReason() {
		return this.unlockReason;
	}
	
	public void setUnlockReason(java.lang.String value) {
		this.unlockReason = value;
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

}

