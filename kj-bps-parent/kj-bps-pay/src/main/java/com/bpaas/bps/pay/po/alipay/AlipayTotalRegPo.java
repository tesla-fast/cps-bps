package com.bpaas.bps.pay.po.alipay;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Jason
 * @Date: 2019/07/04
 * @Description:
 * @version: 1.0
 */
public class AlipayTotalRegPo {

    private String billDate;

    private String storeId;

    private String storeName;

    private Integer tranNum;

    private Integer refundNum;

    private BigDecimal orderAmount;

    private BigDecimal receiptAmount;

    private BigDecimal zfbDiscountAmount;

    private BigDecimal busDiscountAmount;

    private BigDecimal cardAmount;

    private BigDecimal svcAmount;

    private BigDecimal bftAmount;

    private BigDecimal netAmount;

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

    public Integer getTranNum() {
        return tranNum;
    }

    public void setTranNum(Integer tranNum) {
        this.tranNum = tranNum;
    }

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
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

    public BigDecimal getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(BigDecimal cardAmount) {
        this.cardAmount = cardAmount;
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

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
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