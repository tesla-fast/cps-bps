package com.bpaas.bps.user.po;

/**
 * 白名单查询
 * @author haowen.wang
 *
 */
public class UsrWhitePo {

	private int wuid;
	
	private String mobile;
	
	private String flag;

	public int getWuid() {
		return wuid;
	}

	public void setWuid(int wuid) {
		this.wuid = wuid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
