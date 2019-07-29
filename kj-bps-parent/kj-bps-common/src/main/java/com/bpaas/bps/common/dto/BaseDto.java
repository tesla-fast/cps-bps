package com.bpaas.bps.common.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 公共业务数据结构
 * 
 */
public class BaseDto extends SysHeadDto {

    /**
     * 交易名称
     */
    private String transName;

    /**
     * 服务流水号
     */
    private String sysSeq;

    /**
     * 系统日期
     */
    private Date sysDate;

    /**
     * 系统状态
     */
    private String sysStat;

    /**
     * 系统时间
     */
    private Date sysTime;

    /**
     * 是否金融交易 1：是 0：否
     */
    private String amtFlag;

    /**
     * 借贷标志 当AMT_FLAG为1时针对账户而非对方账户 D：借 C：贷
     */
    private String dcFlag;

    /**
     * 短信模板编号列表
     */
    private Map<String, List<String>> smsNos;

    /**
     * 平台消息模板编号列表
     */
    private Map<String, List<String>> noticeNos;
    /**
     * 平台消息模板编号列表， 外层key为发送对象类型
     * ，list为GnrNoticeConfPo部分字段（noticeMsg，noticeNo，noticeSendObj
     * ，noticeLevel）的集合
     */
    private Map<String, List<Map<String, Object>>> noticeNoMaps;
    /**
     * 积分返还标志
     */
    private String pointsReturnFlag;
    /**
     * 消息目标对象(向谁按哪些消息模板发送消息) KEY为消息发送对象类型 1：本人 2：关系人 VALUE为待发送的用户号（USER_ID）
     */
    private Map<String, String[]> targetObjNotice;

    /**
     * 短信目标对象(向谁按哪些短信模板发送短信) KEY为短信发送对象类型 1：本人 2：关系人 VALUE为待发送的手机号（MOBILE）
     */
    private Map<String, String[]> targetObjSms;

    /**
     * 短信参数集合,以PO的字段名定义，每个字段以“|”分割
     */
    private String smsEventParams;

    /**
     * 短信参数集合,以PO的字段名定义，每个字段以“|”分割
     */
    private String noticeEventParams;

    /** 冲正流水号 ，对于同一条记录，每次调用时都是一样的 */
    private String safSysSeq;

    /** 冲正时间 */
    private Date safTime;

    /**
     * 短信验证标志 0:不验证 1：验证
     */
    private String smsCodeVerifyFlag = "0";

    /**
     * TOKEN校验标志
     */
    private String validateTokenFlag;

    /**
     * 系统访问控制标志
     */
    private String accessControlFlag;

    /**
     * 微信渠道关联检查标志
     */
    private String userWechatCheckFlag;

    /**
     * 用户登录状态检查
     */
    private String userLoginStatCheckFlag;

    /**
     * 图形验证码校验标志
     */
    private String graphicsVeryfyCodeFlag;

    /**
     * 短信验证码验证标志
     */
    private String smsVerifyFlag;

    /**
     * 用户状态检查标志
     */
    private String userStatCheckFlag;

    /**
     * 用户登录密码校验标志
     */
    private String loginPwdCheckFlag;

    /**
     * 用户交易密码校验标志
     */
    private String tradePwdCheckFlag;
   
    /**
     * 用户身份证留存校验标志
     */
    private String validateCertCardFlag = "0";


    public String getTransName() {
        return transName;
    }


    public void setTransName(String transName) {
        this.transName = transName;
    }


    public String getSysSeq() {
        return sysSeq;
    }


    public void setSysSeq(String sysSeq) {
        this.sysSeq = sysSeq;
    }


    public Date getSysDate() {
        return sysDate;
    }


    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }


    public String getPointsReturnFlag() {
        return pointsReturnFlag;
    }


    public void setPointsReturnFlag(String pointsReturnFlag) {
        this.pointsReturnFlag = pointsReturnFlag;
    }


    public String getSysStat() {
        return sysStat;
    }


    public void setSysStat(String sysStat) {
        this.sysStat = sysStat;
    }


    public Date getSysTime() {
        return sysTime;
    }


    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }


    public String getAmtFlag() {
        return amtFlag;
    }


    public void setAmtFlag(String amtFlag) {
        this.amtFlag = amtFlag;
    }


    public String getDcFlag() {
        return dcFlag;
    }


    public void setDcFlag(String dcFlag) {
        this.dcFlag = dcFlag;
    }


    public Map<String, List<String>> getSmsNos() {
        return smsNos;
    }


    public void setSmsNos(Map<String, List<String>> smsNos) {
        this.smsNos = smsNos;
    }


    public Map<String, List<String>> getNoticeNos() {
        return noticeNos;
    }


    public void setNoticeNos(Map<String, List<String>> noticeNos) {
        this.noticeNos = noticeNos;
    }


    public Map<String, String[]> getTargetObjNotice() {
        return targetObjNotice;
    }


    public void setTargetObjNotice(Map<String, String[]> targetObjNotice) {
        this.targetObjNotice = targetObjNotice;
    }


    public Map<String, String[]> getTargetObjSms() {
        return targetObjSms;
    }


    public void setTargetObjSms(Map<String, String[]> targetObjSms) {
        this.targetObjSms = targetObjSms;
    }


    public String getSmsEventParams() {
        return smsEventParams;
    }


    public void setSmsEventParams(String smsEventParams) {
        this.smsEventParams = smsEventParams;
    }


    public String getNoticeEventParams() {
        return noticeEventParams;
    }


    public void setNoticeEventParams(String noticeEventParams) {
        this.noticeEventParams = noticeEventParams;
    }


    public String getSafSysSeq() {
        return safSysSeq;
    }


    public void setSafSysSeq(String safSysSeq) {
        this.safSysSeq = safSysSeq;
    }


    public Date getSafTime() {
        return safTime;
    }


    public void setSafTime(Date safTime) {
        this.safTime = safTime;
    }


    public String getSmsCodeVerifyFlag() {
        return smsCodeVerifyFlag;
    }


    public void setSmsCodeVerifyFlag(String smsCodeVerifyFlag) {
        this.smsCodeVerifyFlag = smsCodeVerifyFlag;
    }


    public String getValidateTokenFlag() {
        return validateTokenFlag;
    }


    public void setValidateTokenFlag(String validateTokenFlag) {
        this.validateTokenFlag = validateTokenFlag;
    }


    public String getAccessControlFlag() {
        return accessControlFlag;
    }


    public void setAccessControlFlag(String accessControlFlag) {
        this.accessControlFlag = accessControlFlag;
    }


    public String getUserWechatCheckFlag() {
        return userWechatCheckFlag;
    }


    public void setUserWechatCheckFlag(String userWechatCheckFlag) {
        this.userWechatCheckFlag = userWechatCheckFlag;
    }


    public String getUserLoginStatCheckFlag() {
        return userLoginStatCheckFlag;
    }


    public void setUserLoginStatCheckFlag(String userLoginStatCheckFlag) {
        this.userLoginStatCheckFlag = userLoginStatCheckFlag;
    }


    public String getGraphicsVeryfyCodeFlag() {
        return graphicsVeryfyCodeFlag;
    }


    public void setGraphicsVeryfyCodeFlag(String graphicsVeryfyCodeFlag) {
        this.graphicsVeryfyCodeFlag = graphicsVeryfyCodeFlag;
    }


    public String getSmsVerifyFlag() {
        return smsVerifyFlag;
    }


    public void setSmsVerifyFlag(String smsVerifyFlag) {
        this.smsVerifyFlag = smsVerifyFlag;
    }


    public String getUserStatCheckFlag() {
        return userStatCheckFlag;
    }


    public void setUserStatCheckFlag(String userStatCheckFlag) {
        this.userStatCheckFlag = userStatCheckFlag;
    }


    public String getLoginPwdCheckFlag() {
        return loginPwdCheckFlag;
    }


    public void setLoginPwdCheckFlag(String loginPwdCheckFlag) {
        this.loginPwdCheckFlag = loginPwdCheckFlag;
    }


    public String getTradePwdCheckFlag() {
        return tradePwdCheckFlag;
    }


    public void setTradePwdCheckFlag(String tradePwdCheckFlag) {
        this.tradePwdCheckFlag = tradePwdCheckFlag;
    }


    public Map<String, List<Map<String, Object>>> getNoticeNoMaps() {
        return noticeNoMaps;
    }


    public void setNoticeNoMaps(Map<String, List<Map<String, Object>>> noticeNoMaps) {
        this.noticeNoMaps = noticeNoMaps;
    }


	public String getValidateCertCardFlag() {
		return validateCertCardFlag;
	}


	public void setValidateCertCardFlag(String validateCertCardFlag) {
		this.validateCertCardFlag = validateCertCardFlag;
	}

}
