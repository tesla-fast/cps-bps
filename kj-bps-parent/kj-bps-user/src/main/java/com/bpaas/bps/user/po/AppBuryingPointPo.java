package com.bpaas.bps.user.po;

import java.util.Date;

public class AppBuryingPointPo {

    private String appFlag;

    private String org;

    private String isNewCustomer;

    private String eId;

    private String name;

    private String mobile;

    private String idType;

    private String idNo;

    private String productName;

    private String isOrder;

    private String isPay;

    private Double totalAmount;

    private Date createTime;

    public String getAppFlag() {
        return appFlag;
    }

    public void setAppFlag(String appFlag) {
        this.appFlag = appFlag == null ? null : appFlag.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public String getIsNewCustomer() {
        return isNewCustomer;
    }

    public void setIsNewCustomer(String isNewCustomer) {
        this.isNewCustomer = isNewCustomer == null ? null : isNewCustomer.trim();
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId == null ? null : eId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getIsOrder() {
        return isOrder;
    }

    public void setIsOrder(String isOrder) {
        this.isOrder = isOrder == null ? null : isOrder.trim();
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay == null ? null : isPay.trim();
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}