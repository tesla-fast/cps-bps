package com.bpaas.bps.user.po;

public class UsrLogListPo {
    /**
     * 用户ID db_column: USER_ID
     */
    private java.lang.String userId;
    /**
     * 登录渠道 db_column: CHNL_ID
     */
    private java.lang.String chnlId;
    /**
     * 登录方式 db_column: LOGIN_MODE
     */
    private java.lang.String loginMode;
    /**
     * 是否多点登录 db_column: IS_MUTIPLUE_LOGIN
     */
    private java.lang.String isMutiplueLogin;
    /**
     * SESSION_ID db_column: SESSION_ID
     */
    private java.lang.String sessionId;
    /**
     * 登录平台类型 db_column: PLATFORM
     */
    private java.lang.String platform;
    /**
     * 用户登录时间 db_column: LOGIN_TIME
     */
    private java.util.Date loginTime;
    /**
     * 用户退出时间 db_column: LOGOUT_TIME
     */
    private java.util.Date logoutTime;
    /**
     * 用户登录地 db_column: LOGIN_ADDR
     */
    private java.lang.String loginAddr;
    /**
     * 用户登录IP db_column: LOGIN_IP
     */
    private java.lang.String loginIp;
    /**
     * 地址转换标志 db_column: ADDR_GET_FLAG
     */
    private java.lang.String addrGetFlag;
    /**
     * 省(直辖市) db_column: ADDR_PROV
     */
    private java.lang.String addrProv;
    /**
     * 地级市 db_column: ADDR_CITY
     */
    private java.lang.String addrCity;
    /**
     * 县级市(区，县) db_column: ADDR_COUNTY
     */
    private java.lang.String addrCounty;
    /**
     * 详细地址 db_column: ADDR_DETAIL
     */
    private java.lang.String addrDetail;
    /**
     * 用户登录状态 db_column: LOGIN_STAT
     */
    private java.lang.String loginStat;
    /**
     * 登录失败原因 db_column: FAIL_REASON
     */
    private java.lang.String failReason;
    /**
     * 登录提示说明 db_column: LOGIN_TIPS
     */
    private java.lang.String loginTips;
    /**
     * 备用1 db_column: REMARK1
     */
    private java.lang.String remark1;
    /**
     * 备用2 db_column: REMARK2
     */
    private java.lang.String remark2;
    /**
     * 登录设备 db_column: LOGIN_DEVICE
     */
    private java.lang.String loginDevice;


    // columns END

    public java.lang.String getUserId() {
        return this.userId;
    }


    public void setUserId(java.lang.String value) {
        this.userId = value;
    }


    public java.lang.String getChnlId() {
        return this.chnlId;
    }


    public void setChnlId(java.lang.String value) {
        this.chnlId = value;
    }


    public java.lang.String getLoginMode() {
        return this.loginMode;
    }


    public void setLoginMode(java.lang.String value) {
        this.loginMode = value;
    }


    public java.lang.String getIsMutiplueLogin() {
        return this.isMutiplueLogin;
    }


    public void setIsMutiplueLogin(java.lang.String value) {
        this.isMutiplueLogin = value;
    }


    public java.lang.String getSessionId() {
        return this.sessionId;
    }


    public void setSessionId(java.lang.String value) {
        this.sessionId = value;
    }


    public java.lang.String getPlatform() {
        return this.platform;
    }


    public void setPlatform(java.lang.String value) {
        this.platform = value;
    }


    public java.util.Date getLoginTime() {
        return this.loginTime;
    }


    public void setLoginTime(java.util.Date value) {
        this.loginTime = value;
    }


    public java.util.Date getLogoutTime() {
        return this.logoutTime;
    }


    public void setLogoutTime(java.util.Date value) {
        this.logoutTime = value;
    }


    public java.lang.String getLoginAddr() {
        return this.loginAddr;
    }


    public void setLoginAddr(java.lang.String value) {
        this.loginAddr = value;
    }


    public java.lang.String getLoginIp() {
        return this.loginIp;
    }


    public void setLoginIp(java.lang.String value) {
        this.loginIp = value;
    }


    public java.lang.String getAddrGetFlag() {
        return this.addrGetFlag;
    }


    public void setAddrGetFlag(java.lang.String value) {
        this.addrGetFlag = value;
    }


    public java.lang.String getAddrProv() {
        return this.addrProv;
    }


    public void setAddrProv(java.lang.String value) {
        this.addrProv = value;
    }


    public java.lang.String getAddrCity() {
        return this.addrCity;
    }


    public void setAddrCity(java.lang.String value) {
        this.addrCity = value;
    }


    public java.lang.String getAddrCounty() {
        return this.addrCounty;
    }


    public void setAddrCounty(java.lang.String value) {
        this.addrCounty = value;
    }


    public java.lang.String getAddrDetail() {
        return this.addrDetail;
    }


    public void setAddrDetail(java.lang.String value) {
        this.addrDetail = value;
    }


    public java.lang.String getLoginStat() {
        return this.loginStat;
    }


    public void setLoginStat(java.lang.String value) {
        this.loginStat = value;
    }


    public java.lang.String getFailReason() {
        return this.failReason;
    }


    public void setFailReason(java.lang.String value) {
        this.failReason = value;
    }


    public java.lang.String getLoginTips() {
        return this.loginTips;
    }


    public void setLoginTips(java.lang.String value) {
        this.loginTips = value;
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


    public java.lang.String getLoginDevice() {
        return loginDevice;
    }


    public void setLoginDevice(java.lang.String loginDevice) {
        this.loginDevice = loginDevice;
    }

}
