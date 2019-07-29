package com.bpaas.bps.common.dto;

/**
 * 渠道端系统头数据结构
 * 
 */
public class SysHeadDto extends BpsDto {

    /**
     * 渠道代码
     */
    private String chnlId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 平台类型
     */
    private String platform;

    /**
     * IP/经纬度
     */
    private String address;

    /**
     * 版本号
     */
    private String version;

    /**
     * 微信OPEN_ID
     */
    private String openId;

    /**
     * SESSION ID
     */
    private String sessionId;
    
    /**
     * AES加解密参数
     */
    private String aesKey;

    /**
     * 本页的记录数大小
     */
    private int currentNum;

    /**
     * 查询起始记录数
     */
    private int pageIndex;

    /**
     * 总记录数
     */
    private int totalNum;


    public String getChnlId() {
        return chnlId;
    }


    public void setChnlId(String chnlId) {
        this.chnlId = chnlId;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getPlatform() {
        return platform;
    }


    public void setPlatform(String platform) {
        this.platform = platform;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getVersion() {
        return version;
    }


    public void setVersion(String version) {
        this.version = version;
    }

	public String getOpenId() {
		return openId;
	}


	public void setOpenId(String openId) {
		this.openId = openId;
	}


	public String getSessionId() {
        return sessionId;
    }


    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public String getAesKey() {
		return aesKey;
	}


	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}


	public int getCurrentNum() {
        return currentNum;
    }


    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }


    public int getPageIndex() {
        return pageIndex;
    }


    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }


    public int getTotalNum() {
        return totalNum;
    }


    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

}
