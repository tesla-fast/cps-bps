
package com.bpaas.bps.user.po;

public class UsrRewardsDtlsPo {
    /**
     * 用户ID       db_column: USER_ID 
     */ 	
	private java.lang.String userId;
    /**
     * 奖励唯一标识       db_column: REWARDS_CODE 
     */ 	
	private java.lang.String rewardsCode;
    /**
     * 奖励名称       db_column: REWARDS_NAME 
     */ 	
	private java.lang.String rewardsName;
    /**
     * 奖励类型01红包02优惠券03金币04实物05其他       db_column: REWARDS_TYPE 
     */ 	
	private java.lang.String rewardsType;
    /**
     * 奖励创建日期       db_column: REWARDS_DATE 
     */ 	
	private java.util.Date rewardsDate;
    /**
     * 奖励来源       db_column: REWARDS_FROM 
     */ 	
	private java.lang.String rewardsFrom;
    /**
     * 奖励计划标识       db_column: PLAN_ID 
     */ 	
	private java.lang.String planId;
    /**
     * 奖励金额       db_column: REWARDS_AMT 
     */ 	
	private java.math.BigDecimal rewardsAmt;
    /**
     * 使用说明       db_column: USED_DESC 
     */ 	
	private java.lang.String usedDesc;
    /**
     * 使用范围       db_column: SCOPE_TYPE 
     */ 	
	private java.lang.String scopeType;
    /**
     * 与使用范围对应的交易起始金额       db_column: TRANS_AMT 
     */ 	
	private java.lang.String transAmt;
    /**
     * 生效日期       db_column: START_DATE 
     */ 	
	private java.util.Date startDate;
    /**
     * 失效日期       db_column: END_DATE 
     */ 	
	private java.util.Date endDate;
    /**
     * 领取日期0未领取1已领取2不可领取       db_column: GET_DATE 
     */ 	
	private java.util.Date getDate;
    /**
     * 领取状态       db_column: GET_STAT 
     */ 	
	private java.lang.String getStat;
    /**
     * 使用详情       db_column: USED_DTLS 
     */ 	
	private java.lang.String usedDtls;
    /**
     * 使用时间       db_column: USED_TIME 
     */ 	
	private java.util.Date usedTime;
    /**
     * 奖励状态0未使用1已使用2不可使用       db_column: REWARDS_STATUS 
     */ 	
	private java.lang.String rewardsStatus;
    /**
     * 最后修改时间       db_column: DATELASTMAINT 
     */ 	
	private java.util.Date datelastmaint;
    /**
     * 备注1       db_column: REMARK1 
     */ 	
	private java.lang.String remark1;
    /**
     * 备注2       db_column: REMARK2 
     */ 	
	private java.lang.String remark2;
    /**
     * 备注3       db_column: REMARK3 
     */ 	
	private java.lang.String remark3;
    /**
     * 交易代码       db_column: TRANS_CODE 
     */ 	
	private java.lang.String transCode;
    /**
     * 渠道id       db_column: CHNL_ID 
     */ 	
	private java.lang.String chnlId;
	//columns END
	
	
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.String value) {
		this.userId = value;
	}
	
	
	public java.lang.String getRewardsCode() {
		return this.rewardsCode;
	}
	
	public void setRewardsCode(java.lang.String value) {
		this.rewardsCode = value;
	}
	
	
	public java.lang.String getRewardsName() {
		return this.rewardsName;
	}
	
	public void setRewardsName(java.lang.String value) {
		this.rewardsName = value;
	}
	
	
	public java.lang.String getRewardsType() {
		return this.rewardsType;
	}
	
	public void setRewardsType(java.lang.String value) {
		this.rewardsType = value;
	}
	
	
	public java.util.Date getRewardsDate() {
		return this.rewardsDate;
	}
	
	public void setRewardsDate(java.util.Date value) {
		this.rewardsDate = value;
	}
	
	
	public java.lang.String getRewardsFrom() {
		return this.rewardsFrom;
	}
	
	public void setRewardsFrom(java.lang.String value) {
		this.rewardsFrom = value;
	}
	
	
	public java.lang.String getPlanId() {
		return this.planId;
	}
	
	public void setPlanId(java.lang.String value) {
		this.planId = value;
	}
	
	
	public java.math.BigDecimal getRewardsAmt() {
		return this.rewardsAmt;
	}
	
	public void setRewardsAmt(java.math.BigDecimal value) {
		this.rewardsAmt = value;
	}
	
	
	public java.lang.String getUsedDesc() {
		return this.usedDesc;
	}
	
	public void setUsedDesc(java.lang.String value) {
		this.usedDesc = value;
	}
	
	
	public java.lang.String getScopeType() {
		return this.scopeType;
	}
	
	public void setScopeType(java.lang.String value) {
		this.scopeType = value;
	}
	
	
	public java.lang.String getTransAmt() {
		return this.transAmt;
	}
	
	public void setTransAmt(java.lang.String value) {
		this.transAmt = value;
	}
	
	
	public java.util.Date getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(java.util.Date value) {
		this.startDate = value;
	}
	
	
	public java.util.Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(java.util.Date value) {
		this.endDate = value;
	}
	
	
	public java.util.Date getGetDate() {
		return this.getDate;
	}
	
	public void setGetDate(java.util.Date value) {
		this.getDate = value;
	}
	
	
	public java.lang.String getGetStat() {
		return this.getStat;
	}
	
	public void setGetStat(java.lang.String value) {
		this.getStat = value;
	}
	
	
	public java.lang.String getUsedDtls() {
		return this.usedDtls;
	}
	
	public void setUsedDtls(java.lang.String value) {
		this.usedDtls = value;
	}
	
	
	public java.util.Date getUsedTime() {
		return this.usedTime;
	}
	
	public void setUsedTime(java.util.Date value) {
		this.usedTime = value;
	}
	
	
	public java.lang.String getRewardsStatus() {
		return this.rewardsStatus;
	}
	
	public void setRewardsStatus(java.lang.String value) {
		this.rewardsStatus = value;
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
	
	public java.lang.String getTransCode() {
		return this.transCode;
	}
	
	public void setTransCode(java.lang.String value) {
		this.transCode = value;
	}
	
	public java.lang.String getChnlId() {
		return this.chnlId;
	}
	
	public void setChnlId(java.lang.String value) {
		this.chnlId = value;
	}

}

