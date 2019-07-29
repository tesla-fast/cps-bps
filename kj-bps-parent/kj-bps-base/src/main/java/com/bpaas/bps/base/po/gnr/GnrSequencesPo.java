package com.bpaas.bps.base.po.gnr;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 系统序列表
 * @version: 1.0
 */
public class GnrSequencesPo {

    public static final String TABLE_ALIAS = "GnrSequences";
    public static final String ALIAS_NAME = "序列名";
    public static final String ALIAS_CURRVAL = "当前值";
    public static final String ALIAS_NEXTVAL = "下一值";
    public static final String ALIAS_INCREASE = "递增值";
    public static final String ALIAS_INITVAL = "初始值";
    public static final String ALIAS_MAXVAL = "最大值";
    public static final String ALIAS_CYCLE = "是否循环 0：不循环 1：循环";
    public static final String ALIAS_ID = "PK";

    private String id;
    /**
     * 序列名       db_column: NAME
     */
    private String name;
    /**
     * 当前值       db_column: CURRVAL
     */
    private Long currval;
    /**
     * 下一值       db_column: NEXTVAL
     */
    private Long nextval;
    /**
     * 递增值       db_column: INCREASE
     */
    private Long increase;
    /**
     * 初始值       db_column: INITVAL
     */
    private Long initval;
    /**
     * 最大值       db_column: MAXVAL
     */
    private Long maxval;
    /**
     * 是否循环 0：不循环 1：循环       db_column: CYCLE
     */
    private String cycle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }


    public Long getCurrval() {
        return currval;
    }

    public void setCurrval(Long currval) {
        this.currval = currval;
    }

    public Long getNextval() {
        return nextval;
    }

    public void setNextval(Long nextval) {
        this.nextval = nextval;
    }

    public Long getIncrease() {
        return increase;
    }

    public void setIncrease(Long increase) {
        this.increase = increase;
    }

    public Long getInitval() {
        return initval;
    }

    public void setInitval(Long initval) {
        this.initval = initval;
    }

    public Long getMaxval() {
        return maxval;
    }

    public void setMaxval(Long maxval) {
        this.maxval = maxval;
    }

    public String getCycle() {
        return this.cycle;
    }

    public void setCycle(String value) {
        this.cycle = value;
    }
}
