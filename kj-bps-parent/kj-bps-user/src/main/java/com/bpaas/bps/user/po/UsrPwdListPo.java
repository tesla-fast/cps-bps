package com.bpaas.bps.user.po;

public class UsrPwdListPo {

    /**
     * 用户ID db_column: USER_ID
     */
    private java.lang.String userId;
    /**
     * 统计日期 db_column: COUNT_DATE
     */
    private java.util.Date countDate;
    /**
     * 当日登录密码连续错误次数 db_column: LOG_DAY_ERR
     */
    private java.lang.Long logDayErr;
    /**
     * 登录密码连续错误总次数 db_column: LOG_TOT_ERR
     */
    private java.lang.Long logTotErr;
    /**
     * 最后一次登录密码错误时间 db_column: LAST_LOGPWD_ERRTIME
     */
    private java.util.Date lastLogpwdErrtime;
    /**
     * 当日交易密码连续错误次数 db_column: TRADE_DAY_ERR
     */
    private java.lang.Long tradeDayErr;
    /**
     * 交易密码连续错误总次数 db_column: TRADE_TOT_ERR
     */
    private java.lang.Long tradeTotErr;
    /**
     * 最后一次交易密码错误时间 db_column: LAST_TRADEPWD_ERRTIME
     */
    private java.util.Date lastTradepwdErrtime;
    /**
     * 当日查询密码连续错误次数 db_column: QUERY_DAY_ERR
     */
    private java.lang.Long queryDayErr;
    /**
     * 查询密码连续错误总次数 db_column: QUERY_TOT_ERR
     */
    private java.lang.Long queryTotErr;
    /**
     * 最后一次查询密码错误时间 db_column: LAST_QUERYPWD_ERRTIME
     */
    private java.util.Date lastQuerypwdErrtime;
    /**
     * 当日手势密码连续错误次数db_column: GESTURE_DAY_ERR
     */
    private java.lang.Long gestureDayErr;
    /**
     * 当日指纹密码连续错误次数db_column: FINGERPRINT_DAY_ERR
     */
    private java.lang.Long fingerprintDayErr;
    /**
     * 备用1 db_column: REMARK1
     */
    private java.lang.String remark1;
    /**
     * 备用2 db_column: REMARK2
     */
    private java.lang.String remark2;
    /**
     * 备用3 db_column: REMARK3
     */
    private java.lang.String remark3;


    // columns END

    public java.lang.String getUserId() {
        return this.userId;
    }


    public java.lang.Long getFingerprintDayErr() {
		return fingerprintDayErr;
	}


	public void setFingerprintDayErr(java.lang.Long fingerprintDayErr) {
		this.fingerprintDayErr = fingerprintDayErr;
	}


	public java.lang.Long getGestureDayErr() {
		return gestureDayErr;
	}


	public void setGestureDayErr(java.lang.Long gestureDayErr) {
		this.gestureDayErr = gestureDayErr;
	}


	public void setUserId(java.lang.String value) {
        this.userId = value;
    }


    public java.util.Date getCountDate() {
        return this.countDate;
    }


    public void setCountDate(java.util.Date value) {
        this.countDate = value;
    }


    public java.lang.Long getLogDayErr() {
        return this.logDayErr;
    }


    public void setLogDayErr(java.lang.Long value) {
        this.logDayErr = value;
    }


    public java.lang.Long getLogTotErr() {
        return this.logTotErr;
    }


    public void setLogTotErr(java.lang.Long value) {
        this.logTotErr = value;
    }


    public java.util.Date getLastLogpwdErrtime() {
        return this.lastLogpwdErrtime;
    }


    public void setLastLogpwdErrtime(java.util.Date value) {
        this.lastLogpwdErrtime = value;
    }


    public java.lang.Long getTradeDayErr() {
        return this.tradeDayErr;
    }


    public void setTradeDayErr(java.lang.Long value) {
        this.tradeDayErr = value;
    }


    public java.lang.Long getTradeTotErr() {
        return this.tradeTotErr;
    }


    public void setTradeTotErr(java.lang.Long value) {
        this.tradeTotErr = value;
    }


    public java.util.Date getLastTradepwdErrtime() {
        return this.lastTradepwdErrtime;
    }


    public void setLastTradepwdErrtime(java.util.Date value) {
        this.lastTradepwdErrtime = value;
    }


    public java.lang.Long getQueryDayErr() {
        return queryDayErr;
    }


    public void setQueryDayErr(java.lang.Long queryDayErr) {
        this.queryDayErr = queryDayErr;
    }


    public java.lang.Long getQueryTotErr() {
        return queryTotErr;
    }


    public void setQueryTotErr(java.lang.Long queryTotErr) {
        this.queryTotErr = queryTotErr;
    }


    public java.util.Date getLastQuerypwdErrtime() {
        return lastQuerypwdErrtime;
    }


    public void setLastQuerypwdErrtime(java.util.Date lastQuerypwdErrtime) {
        this.lastQuerypwdErrtime = lastQuerypwdErrtime;
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
