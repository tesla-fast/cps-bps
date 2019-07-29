package com.bpaas.bps.pay.po.alipay;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Jason
 * @Date: 2019/07/04
 * @Description:
 * @version: 1.0
 */
public class AlipayDetailRegPo {
	
    private String billDate;

    private String tradeNo;

    private String outTradeNo;

    private String tranType;

    private String body;

    private Date gmtCreate;

    private Date gmtClose;

    private String storeId;

    private String storeName;

    private String operatorId;

    private String terminalId;

    private String acctno;

    private BigDecimal totalAmount;

    private BigDecimal receiptAmount;

    private BigDecimal redAmount;

    private BigDecimal pointAmount;

    private BigDecimal zfbDiscountAmount;

    private BigDecimal busDiscountAmount;

    private BigDecimal ticketAmount;

    private String ticketName;

    private BigDecimal busRedAmount;

    private BigDecimal cardAmount;

    private String refundId;

    private BigDecimal svcAmount;

    private BigDecimal bftAmount;

    private String remark;

    private String chkflag;

    private Date chktime;

    private String remark1;

    private String remark2;

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType == null ? null : tranType.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtClose() {
        return gmtClose;
    }

    public void setGmtClose(Date gmtClose) {
        this.gmtClose = gmtClose;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId == null ? null : terminalId.trim();
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno == null ? null : acctno.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public BigDecimal getRedAmount() {
        return redAmount;
    }

    public void setRedAmount(BigDecimal redAmount) {
        this.redAmount = redAmount;
    }

    public BigDecimal getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(BigDecimal pointAmount) {
        this.pointAmount = pointAmount;
    }

    public BigDecimal getZfbDiscountAmount() {
        return zfbDiscountAmount;
    }

    public void setZfbDiscountAmount(BigDecimal zfbDiscountAmount) {
        this.zfbDiscountAmount = zfbDiscountAmount;
    }

    public BigDecimal getBusDiscountAmount() {
        return busDiscountAmount;
    }

    public void setBusDiscountAmount(BigDecimal busDiscountAmount) {
        this.busDiscountAmount = busDiscountAmount;
    }

    public BigDecimal getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(BigDecimal ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName == null ? null : ticketName.trim();
    }

    public BigDecimal getBusRedAmount() {
        return busRedAmount;
    }

    public void setBusRedAmount(BigDecimal busRedAmount) {
        this.busRedAmount = busRedAmount;
    }

    public BigDecimal getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(BigDecimal cardAmount) {
        this.cardAmount = cardAmount;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId == null ? null : refundId.trim();
    }

    public BigDecimal getSvcAmount() {
        return svcAmount;
    }

    public void setSvcAmount(BigDecimal svcAmount) {
        this.svcAmount = svcAmount;
    }

    public BigDecimal getBftAmount() {
        return bftAmount;
    }

    public void setBftAmount(BigDecimal bftAmount) {
        this.bftAmount = bftAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}