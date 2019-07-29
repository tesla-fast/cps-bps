package com.bpaas.bps.user.po;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户签到信息表
 * @author fei.meng
 *
 */
public class UsrSignPo {

	private String wuid;
	private String userId;
	private Date signTime;
	private BigDecimal potBal;
	private String reservedField;
	private Date createTime;
	private Integer continueDays;
	
	public String getWuid() {
		return wuid;
	}
	public void setWuid(String wuid) {
		this.wuid = wuid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	public String getReservedField() {
		return reservedField;
	}
	public void setReservedField(String reservedField) {
		this.reservedField = reservedField;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getPotBal() {
		return potBal;
	}
	public void setPotBal(BigDecimal potBal) {
		this.potBal = potBal;
	}
	public Integer getContinueDays() {
		return continueDays;
	}
	public void setContinueDays(Integer continueDays) {
		this.continueDays = continueDays;
	}
	
}
