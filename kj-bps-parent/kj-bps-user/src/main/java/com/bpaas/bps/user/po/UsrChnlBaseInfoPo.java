package com.bpaas.bps.user.po;

import java.util.Date;

/**
 * 渠道用户基本信息表
 */
public class UsrChnlBaseInfoPo {

	// 用户ID
	private String userId;
	// 商户ID
	private String merchantId;
	// 证件类型
	private String certType;
	// 证件号码
	private String certNo;
	// 用户姓名
	private String certName;
	// 注册渠道
	private String regChnlId;
	// 注册时间
	private Date regTime;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantId() {
		return this.merchantId;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertType() {
		return this.certType;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCertNo() {
		return this.certNo;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getCertName() {
		return this.certName;
	}

	public void setRegChnlId(String regChnlId) {
		this.regChnlId = regChnlId;
	}

	public String getRegChnlId() {
		return this.regChnlId;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Date getRegTime() {
		return this.regTime;
	}

}