package com.bpaas.bps.user.common.po;

public class UsrRegInfoPo {
	private String id;
    /**
     * 用户ID db_column: USER_ID
     */
    private java.lang.String userId;
    /**
     * 手机号 db_column: MOBILE
     */
    private java.lang.String mobile;
    /**
     * 用户登录名 db_column: USER_NAME
     */
    private java.lang.String userName;
    /**
     * 用户昵称 db_column: USER_NICK_NAME
     */
    private java.lang.String userNickName;
    /**
     * 用户头像图片地址 db_column: HEAD_PIC
     */
    private java.lang.String headPic;
    /**
     * 登录密码 db_column: LOGIN_PWD
     */
    private java.lang.String loginPwd;
    /**
     * 最后一次登录密码修改时间 db_column: LAST_LOGPWD_MODIFYTIME
     */
    private java.util.Date lastLogpwdModifytime;
    /**
     * 交易密码 db_column: TRADE_PWD
     */
    private java.lang.String tradePwd;
    /**
     * 最后一次交易密码修改时间 db_column: LAST_TRADEPWD_MODIFYTIME
     */
    private java.util.Date lastTradepwdModifytime;
    /**
     * 交易密码 db_column: GASTURE_PWD
     */
    private java.lang.String gasturePwd;
    /**
     * 最后一次交易密码修改时间 db_column: LAST_GASTUREPWD_MODIFYTIME
     */
    private java.util.Date lastGasturepwdModifytime;
    /**
     * 合作平台类型 db_column: UNION_PLAT_TYPE
     */
    private java.lang.String unionPlatType;
    /**
     * 合作平台账号 db_column: UNION_PLAT_NO
     */
    private java.lang.String unionPlatNo;
    /**
     * 注册时间 db_column: REG_TIME
     */
    private java.util.Date regTime;
    /**
     * 注册渠道 db_column: REG_CHNL_ID
     */
    private java.lang.String regChnlId;
    /**
     * 用户认证等级 db_column: USER_CERT_LEVEL
     */
    private java.lang.String userCertLevel;
    /**
     * 用户价值等级 db_column: USER_VALUE_LEVEL
     */
    private java.lang.String userValueLevel;
    /**
     * 所属机构 db_column: BRANCH_ID
     */
    private java.lang.String branchId;
    /**
     * 用户状态 db_column: USER_STAT
     */
    private java.lang.String userStat;
    /**
     * 锁定标志 db_column: USER_LOCK_FLAG
     * 
     * 1锁定0正常: 第1位登陆密码, 第2位交易密码, 第3位登陆密码
     */
    private java.lang.String userLockFlag;
    /**
     * 黑名单标志 db_column: BLACKLIST_FLAG
     */
    private java.lang.String blacklistFlag;
    /**
     * 黑名单类型代码 db_column: BLACKLIST_TYPE
     */
    private java.lang.String blacklistType;
    /**
     * 安全认证方式 db_column: SECURITY_TYPE
     */
    private java.lang.String securityType;
    /**
     * 激活时间 db_column: ACTIVE_TIME
     */
    private java.util.Date activeTime;
    /**
     * 激活渠道 db_column: ACTIVE_CHNL_ID
     */
    private java.lang.String activeChnlId;
    /**
     * 注销时间 db_column: CLOSE_TIME
     */
    private java.util.Date closeTime;
    /**
     * 注销渠道 db_column: CLOSE_CHNL_ID
     */
    private java.lang.String closeChnlId;
    /**
     * 最后修改时间 db_column: LAST_UPDATE_TIME
     */
    private java.util.Date lastUpdateTime;
    /**
     * 备用1 db_column: REMARK1
     */
    private java.lang.String remark1;
    /**
     * 备用2 db_column: REMARK2
     */
    private java.lang.String remark2;
    /**
     * 备用3 db_column: CALL_CENTER_PWD
     */
    private java.lang.String callCenterPwd;
    /**
     * 最后一次登录时间 db_column: LAST_LOGIN_TIME
     */
    private java.util.Date lastLoginTime;
    /**
     * 是否已设置电话银行密码 db_column: IF_CALL_PWD
     */
    private java.lang.String ifCallPwd;
    
    private java.lang.String fingerprintPwd;
    
    private java.lang.String loginKey;
    
    private java.lang.String level;
    
    private java.lang.String gasturePwdFlag;
    
    private java.lang.String fingerprintPwdFlag;
    
    private java.lang.String facePwdFlag;


    // columns END


	public java.lang.String getLoginKey() {
		return loginKey;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public java.lang.String getLevel() {
		return level;
	}


	public void setLevel(java.lang.String level) {
		this.level = level;
	}


	public java.lang.String getFingerprintPwd() {
		return fingerprintPwd;
	}


	public void setFingerprintPwd(java.lang.String fingerprintPwd) {
		this.fingerprintPwd = fingerprintPwd;
	}


	public void setLoginKey(java.lang.String loginKey) {
		this.loginKey = loginKey;
	}


	public java.lang.String getUserId() {
        return this.userId;
    }


    public void setUserId(java.lang.String value) {
        this.userId = value;
    }


    public java.lang.String getMobile() {
        return this.mobile;
    }


    public void setMobile(java.lang.String value) {
        this.mobile = value;
    }


    public java.lang.String getUserName() {
        return this.userName;
    }


    public void setUserName(java.lang.String value) {
        this.userName = value;
    }


    public java.lang.String getUserNickName() {
        return this.userNickName;
    }


    public void setUserNickName(java.lang.String value) {
        this.userNickName = value;
    }


    public java.lang.String getHeadPic() {
        return this.headPic;
    }


    public void setHeadPic(java.lang.String value) {
        this.headPic = value;
    }


    public java.lang.String getLoginPwd() {
        return this.loginPwd;
    }


    public void setLoginPwd(java.lang.String value) {
        this.loginPwd = value;
    }


    public java.util.Date getLastLogpwdModifytime() {
        return this.lastLogpwdModifytime;
    }


    public void setLastLogpwdModifytime(java.util.Date value) {
        this.lastLogpwdModifytime = value;
    }


    public java.lang.String getTradePwd() {
        return this.tradePwd;
    }


    public void setTradePwd(java.lang.String value) {
        this.tradePwd = value;
    }


    public java.util.Date getLastTradepwdModifytime() {
        return this.lastTradepwdModifytime;
    }


    public void setLastTradepwdModifytime(java.util.Date value) {
        this.lastTradepwdModifytime = value;
    }


    public java.lang.String getUnionPlatType() {
        return this.unionPlatType;
    }


    public void setUnionPlatType(java.lang.String value) {
        this.unionPlatType = value;
    }


    public java.lang.String getUnionPlatNo() {
        return this.unionPlatNo;
    }


    public void setUnionPlatNo(java.lang.String value) {
        this.unionPlatNo = value;
    }


    public java.util.Date getRegTime() {
        return this.regTime;
    }


    public void setRegTime(java.util.Date value) {
        this.regTime = value;
    }


    public java.lang.String getRegChnlId() {
        return this.regChnlId;
    }


    public void setRegChnlId(java.lang.String value) {
        this.regChnlId = value;
    }


    public java.lang.String getUserCertLevel() {
        return this.userCertLevel;
    }


    public void setUserCertLevel(java.lang.String value) {
        this.userCertLevel = value;
    }


    public java.lang.String getUserValueLevel() {
        return this.userValueLevel;
    }


    public void setUserValueLevel(java.lang.String value) {
        this.userValueLevel = value;
    }


    public java.lang.String getBranchId() {
        return this.branchId;
    }


    public void setBranchId(java.lang.String value) {
        this.branchId = value;
    }


    public java.lang.String getUserStat() {
        return this.userStat;
    }


    public void setUserStat(java.lang.String value) {
        this.userStat = value;
    }


    /**
     * 锁定标志
     * 
     * 1锁定0正常: 第1位登陆密码, 第2位交易密码, 第3位登陆密码
     * 
     * @return
     */
    public java.lang.String getUserLockFlag() {
        return this.userLockFlag;
    }


    public void setUserLockFlag(java.lang.String value) {
        this.userLockFlag = value;
    }


    public java.lang.String getBlacklistFlag() {
        return this.blacklistFlag;
    }


    public void setBlacklistFlag(java.lang.String value) {
        this.blacklistFlag = value;
    }


    public java.lang.String getBlacklistType() {
        return this.blacklistType;
    }


    public void setBlacklistType(java.lang.String value) {
        this.blacklistType = value;
    }


    public java.lang.String getSecurityType() {
        return this.securityType;
    }


    public void setSecurityType(java.lang.String value) {
        this.securityType = value;
    }


    public java.util.Date getActiveTime() {
        return this.activeTime;
    }


    public void setActiveTime(java.util.Date value) {
        this.activeTime = value;
    }


    public java.lang.String getActiveChnlId() {
        return this.activeChnlId;
    }


    public void setActiveChnlId(java.lang.String value) {
        this.activeChnlId = value;
    }


    public java.util.Date getCloseTime() {
        return this.closeTime;
    }


    public void setCloseTime(java.util.Date value) {
        this.closeTime = value;
    }


    public java.lang.String getCloseChnlId() {
        return this.closeChnlId;
    }


    public void setCloseChnlId(java.lang.String value) {
        this.closeChnlId = value;
    }


    public java.util.Date getLastUpdateTime() {
        return lastUpdateTime;
    }


    public void setLastUpdateTime(java.util.Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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


    public java.lang.String getCallCenterPwd() {
        return callCenterPwd;
    }


    public void setCallCenterPwd(java.lang.String callCenterPwd) {
        this.callCenterPwd = callCenterPwd;
    }


    public java.util.Date getLastLoginTime() {
        return this.lastLoginTime;
    }


    public void setLastLoginTime(java.util.Date value) {
        this.lastLoginTime = value;
    }


    public java.lang.String getGasturePwd() {
        return gasturePwd;
    }


    public void setGasturePwd(java.lang.String gasturePwd) {
        this.gasturePwd = gasturePwd;
    }


    public java.util.Date getLastGasturepwdModifytime() {
        return lastGasturepwdModifytime;
    }


    public void setLastGasturepwdModifytime(java.util.Date lastGasturepwdModifytime) {
        this.lastGasturepwdModifytime = lastGasturepwdModifytime;
    }


    public java.lang.String getIfCallPwd() {
        return ifCallPwd;
    }


    public void setIfCallPwd(java.lang.String ifCallPwd) {
        this.ifCallPwd = ifCallPwd;
    }


	public java.lang.String getGasturePwdFlag() {
		return gasturePwdFlag;
	}


	public void setGasturePwdFlag(java.lang.String gasturePwdFlag) {
		this.gasturePwdFlag = gasturePwdFlag;
	}


	public java.lang.String getFingerprintPwdFlag() {
		return fingerprintPwdFlag;
	}


	public void setFingerprintPwdFlag(java.lang.String fingerprintPwdFlag) {
		this.fingerprintPwdFlag = fingerprintPwdFlag;
	}


	public java.lang.String getFacePwdFlag() {
		return facePwdFlag;
	}


	public void setFacePwdFlag(java.lang.String facePwdFlag) {
		this.facePwdFlag = facePwdFlag;
	}

}
