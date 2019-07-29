package com.bpaas.bps.pay.po.wechat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Jason
 * @Date: 2019/07/04
 * @Description:
 * @version: 1.0
 */
public class WechatPayDetailRefundRegPo {

    private String billdate;

    private String billType;

    private Date trandate;

    private String appid;

    private String mchId;

    private String subMchId;

    private String deviceInfo;

    private String transactionId;

    private String outTradeNo;

    private String openid;

    private String tradeType;

    private String tradeState;

    private String payerBankcode;

    private String feeType;

    private BigDecimal clearFee;

    private BigDecimal couponFee;

    private Date refundDate;

    private Date refundSuccDate;

    private String refundId;

    private String outRefundNo;

    private BigDecimal refundFee;

    private BigDecimal couponRefundFee;

    private String refundType;

    private String refundStatus;

    private String body;

    private String attach;

    private BigDecimal feeAmt;

    private String rate;

    private BigDecimal orderFee;

    private BigDecimal reqRefundFee;

    private String ratemark;

    private String chkflag;

    private Date chktime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate == null ? null : billdate.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public Date getTrandate() {
        return trandate;
    }

    public void setTrandate(Date trandate) {
        this.trandate = trandate;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId == null ? null : subMchId.trim();
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo == null ? null : deviceInfo.trim();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState == null ? null : tradeState.trim();
    }

    public String getPayerBankcode() {
        return payerBankcode;
    }

    public void setPayerBankcode(String payerBankcode) {
        this.payerBankcode = payerBankcode == null ? null : payerBankcode.trim();
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    public BigDecimal getClearFee() {
        return clearFee;
    }

    public void setClearFee(BigDecimal clearFee) {
        this.clearFee = clearFee;
    }

    public BigDecimal getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(BigDecimal couponFee) {
        this.couponFee = couponFee;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public Date getRefundSuccDate() {
        return refundSuccDate;
    }

    public void setRefundSuccDate(Date refundSuccDate) {
        this.refundSuccDate = refundSuccDate;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId == null ? null : refundId.trim();
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo == null ? null : outRefundNo.trim();
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public BigDecimal getCouponRefundFee() {
        return couponRefundFee;
    }

    public void setCouponRefundFee(BigDecimal couponRefundFee) {
        this.couponRefundFee = couponRefundFee;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach == null ? null : attach.trim();
    }

    public BigDecimal getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public BigDecimal getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(BigDecimal orderFee) {
        this.orderFee = orderFee;
    }

    public BigDecimal getReqRefundFee() {
        return reqRefundFee;
    }

    public void setReqRefundFee(BigDecimal reqRefundFee) {
        this.reqRefundFee = reqRefundFee;
    }

    public String getRatemark() {
        return ratemark;
    }

    public void setRatemark(String ratemark) {
        this.ratemark = ratemark == null ? null : ratemark.trim();
    }

    public String getChkflag() {
        return chkflag;
    }

    public void setChkflag(String chkflag) {
        this.chkflag = chkflag == null ? null : chkflag.trim();
    }

    public Date getChktime() {
        return chktime;
    }

    public void setChktime(Date chktime) {
        this.chktime = chktime;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5 == null ? null : remark5.trim();
    }
}