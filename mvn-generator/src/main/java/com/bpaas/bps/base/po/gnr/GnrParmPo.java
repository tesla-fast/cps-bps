package com.bpaas.bps.base.po.gnr;

import java.util.Date;

public class GnrParmPo {
    private String id;

    private String parmId;

    private String parmFlag;

    private String parmType;

    private String parmName;

    private String parmDesc;

    private String parmValue;

    private Date lastUpdateTime;

    private String lastOper;

    private String remark1;

    private String remark2;

    private String remark3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParmId() {
        return parmId;
    }

    public void setParmId(String parmId) {
        this.parmId = parmId == null ? null : parmId.trim();
    }

    public String getParmFlag() {
        return parmFlag;
    }

    public void setParmFlag(String parmFlag) {
        this.parmFlag = parmFlag == null ? null : parmFlag.trim();
    }

    public String getParmType() {
        return parmType;
    }

    public void setParmType(String parmType) {
        this.parmType = parmType == null ? null : parmType.trim();
    }

    public String getParmName() {
        return parmName;
    }

    public void setParmName(String parmName) {
        this.parmName = parmName == null ? null : parmName.trim();
    }

    public String getParmDesc() {
        return parmDesc;
    }

    public void setParmDesc(String parmDesc) {
        this.parmDesc = parmDesc == null ? null : parmDesc.trim();
    }

    public String getParmValue() {
        return parmValue;
    }

    public void setParmValue(String parmValue) {
        this.parmValue = parmValue == null ? null : parmValue.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastOper() {
        return lastOper;
    }

    public void setLastOper(String lastOper) {
        this.lastOper = lastOper == null ? null : lastOper.trim();
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
}