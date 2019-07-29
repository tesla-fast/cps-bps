package com.bpaas.bps.pay.po.wechat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Jason
 * @Date: 2019/07/04
 * @Description:
 * @version: 1.0
 */
public class WechatPayTotalRegPo {

	private String billDate;

    private String billType;

    private Integer orderSumnum;

    private BigDecimal orderClearsumamt;

    private BigDecimal refundSumamt;

    private BigDecimal couponSumamt;

    private BigDecimal feeSumamt;

    private BigDecimal orderSumamt;

    private BigDecimal reqRefundSumamt;

    private Integer frontSumnum;

    private BigDecimal frontClearSumAmt;

    private BigDecimal frontRefundSumAmt;

    private BigDecimal frontCouponSumamt;

    private BigDecimal frontFeeSumamt;

    private BigDecimal frontOrderSumamt;

    private BigDecimal frontReqRefundSumamt;

    private String chkflag;

    private Date chktime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate == null ? null : billDate.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public Integer getOrderSumnum() {
        return orderSumnum;
    }

    public void setOrderSumnum(Integer orderSumnum) {
        this.orderSumnum = orderSumnum;
    }

    public BigDecimal getOrderClearsumamt() {
        return orderClearsumamt;
    }

    public void setOrderClearsumamt(BigDecimal orderClearsumamt) {
        this.orderClearsumamt = orderClearsumamt;
    }

    public BigDecimal getRefundSumamt() {
        return refundSumamt;
    }

    public void setRefundSumamt(BigDecimal refundSumamt) {
        this.refundSumamt = refundSumamt;
    }

    public BigDecimal getCouponSumamt() {
        return couponSumamt;
    }

    public void setCouponSumamt(BigDecimal couponSumamt) {
        this.couponSumamt = couponSumamt;
    }

    public BigDecimal getFeeSumamt() {
        return feeSumamt;
    }

    public void setFeeSumamt(BigDecimal feeSumamt) {
        this.feeSumamt = feeSumamt;
    }

    public BigDecimal getOrderSumamt() {
        return orderSumamt;
    }

    public void setOrderSumamt(BigDecimal orderSumamt) {
        this.orderSumamt = orderSumamt;
    }

    public BigDecimal getReqRefundSumamt() {
        return reqRefundSumamt;
    }

    public void setReqRefundSumamt(BigDecimal reqRefundSumamt) {
        this.reqRefundSumamt = reqRefundSumamt;
    }

    public Integer getFrontSumnum() {
        return frontSumnum;
    }

    public void setFrontSumnum(Integer frontSumnum) {
        this.frontSumnum = frontSumnum;
    }

    public BigDecimal getFrontClearSumAmt() {
        return frontClearSumAmt;
    }

    public void setFrontClearSumAmt(BigDecimal frontClearSumAmt) {
        this.frontClearSumAmt = frontClearSumAmt;
    }

    public BigDecimal getFrontRefundSumAmt() {
        return frontRefundSumAmt;
    }

    public void setFrontRefundSumAmt(BigDecimal frontRefundSumAmt) {
        this.frontRefundSumAmt = frontRefundSumAmt;
    }

    public BigDecimal getFrontCouponSumamt() {
        return frontCouponSumamt;
    }

    public void setFrontCouponSumamt(BigDecimal frontCouponSumamt) {
        this.frontCouponSumamt = frontCouponSumamt;
    }

    public BigDecimal getFrontFeeSumamt() {
        return frontFeeSumamt;
    }

    public void setFrontFeeSumamt(BigDecimal frontFeeSumamt) {
        this.frontFeeSumamt = frontFeeSumamt;
    }

    public BigDecimal getFrontOrderSumamt() {
        return frontOrderSumamt;
    }

    public void setFrontOrderSumamt(BigDecimal frontOrderSumamt) {
        this.frontOrderSumamt = frontOrderSumamt;
    }

    public BigDecimal getFrontReqRefundSumamt() {
        return frontReqRefundSumamt;
    }

    public void setFrontReqRefundSumamt(BigDecimal frontReqRefundSumamt) {
        this.frontReqRefundSumamt = frontReqRefundSumamt;
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