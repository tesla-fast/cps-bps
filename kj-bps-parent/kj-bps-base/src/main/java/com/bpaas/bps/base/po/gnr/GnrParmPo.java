package com.bpaas.bps.base.po.gnr;

import java.util.Date;

/**
 * @Author: Jason
 * @Date: 2019/07/15
 * @Description: 系统序列表
 * @version: 1.0
 */
public class GnrParmPo {

	public static final String TABLE_ALIAS = "3.18.4 系统参数表";
	public static final String ALIAS_ID = "PK";
	public static final String ALIAS_PARM_ID = "参数标识";
	public static final String ALIAS_PARM_FLAG = "参数类型 00：技术参数 01：业务参数";
	public static final String ALIAS_PARM_TYPE = "01：字符类型 02：日期类型 03：金额类型";
	public static final String ALIAS_PARM_NAME = "参数名称";
	public static final String ALIAS_PARM_DESC = "参数描述";
	public static final String ALIAS_PARM_VALUE = "参数值";
	public static final String ALIAS_CREATE_TIME = "添加时间";
	public static final String ALIAS_UPDATE_TIME = "修改时间";
	public static final String ALIAS_OP_USER = "维护操作员";
	public static final String ALIAS_MEMO = "备用";
	private String id;
	private String parmId;
	private String parmFlag;
	private String parmType;
	private String parmName;
	private String parmDesc;
	private String parmValue;
	private Date createTime;
	private Date updateTime;
	private String opUser;
	private String memo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParmId() {
		return this.parmId;
	}

	public void setParmId(String value) {
		this.parmId = value;
	}

	public String getParmFlag() {
		return this.parmFlag;
	}

	public void setParmFlag(String value) {
		this.parmFlag = value;
	}

	public String getParmType() {
		return this.parmType;
	}

	public void setParmType(String value) {
		this.parmType = value;
	}

	public String getParmName() {
		return this.parmName;
	}

	public void setParmName(String value) {
		this.parmName = value;
	}

	public String getParmDesc() {
		return this.parmDesc;
	}

	public void setParmDesc(String value) {
		this.parmDesc = value;
	}

	public String getParmValue() {
		return this.parmValue;
	}

	public void setParmValue(String value) {
		this.parmValue = value;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date value) {
		this.createTime = value;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}

	public String getOpUser() {
		return this.opUser;
	}

	public void setOpUser(String value) {
		this.opUser = value;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String value) {
		this.memo = value;
	}

}
