package com.bpaas.bps.base.po.gnr;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 系统信息表
 * @version: 1.0
 */
public class GnrSysinfoPo {

    public static final String TABLE_ALIAS = "系统信息表";
    public static final String ALIAS_ID = "PK";
    public static final String ALIAS_SYS_STAT = "系统状态";
    public static final String ALIAS_SYS_DATE = "系统日期";
    public static final String ALIAS_PRE_DATE = "前一日";
    public static final String ALIAS_NEXT_DATE = "后一日";
    public static final String ALIAS_REMARK = "备注";


    /**
     * 系统状态       db_column: SYS_STAT
     */
    private String sysStat;
    /**
     * 系统日期       db_column: SYS_DATE
     */
    private java.util.Date sysDate;
    /**
     * 前一日       db_column: PRE_DATE
     */
    private java.util.Date preDate;
    /**
     * 后一日       db_column: NEXT_DATE
     */
    private java.util.Date nextDate;
    /**
     * 备注       db_column: REMARK
     */
    private String remark;

    public String getSysStat() {
        return this.sysStat;
    }

    public void setSysStat(String value) {
        this.sysStat = value;
    }


    public java.util.Date getSysDate() {
        return this.sysDate;
    }

    public void setSysDate(java.util.Date value) {
        this.sysDate = value;
    }


    public java.util.Date getPreDate() {
        return this.preDate;
    }

    public void setPreDate(java.util.Date value) {
        this.preDate = value;
    }


    public java.util.Date getNextDate() {
        return this.nextDate;
    }

    public void setNextDate(java.util.Date value) {
        this.nextDate = value;
    }


    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String value) {
        this.remark = value;
    }
}
