package com.bpaas.bps.acc.po;

import java.util.Date;

public class AccEBookPo {

	private String id;
	
	private String userId;

    private String eCardNo;

    private String eAcctOrg;

    private String eAcctStat;

    private String frzStat;

    private String eAcctCertLevel;

    private Date createTime;

    private String remark1;

    private String remark2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String geteCardNo() {
		return eCardNo;
	}

	public void seteCardNo(String eCardNo) {
		this.eCardNo = eCardNo;
	}

	public String geteAcctOrg() {
		return eAcctOrg;
	}

	public void seteAcctOrg(String eAcctOrg) {
		this.eAcctOrg = eAcctOrg;
	}

	public String geteAcctStat() {
		return eAcctStat;
	}

	public void seteAcctStat(String eAcctStat) {
		this.eAcctStat = eAcctStat;
	}

	public String getFrzStat() {
		return frzStat;
	}

	public void setFrzStat(String frzStat) {
		this.frzStat = frzStat;
	}

	public String geteAcctCertLevel() {
		return eAcctCertLevel;
	}

	public void seteAcctCertLevel(String eAcctCertLevel) {
		this.eAcctCertLevel = eAcctCertLevel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

}