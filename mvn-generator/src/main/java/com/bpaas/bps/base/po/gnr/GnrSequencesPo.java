package com.bpaas.bps.base.po.gnr;

public class GnrSequencesPo {
    private String id;

    private String name;

    private Integer currval;

    private Integer nextval;

    private Integer increase;

    private Integer initval;

    private Integer maxval;

    private String cycle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCurrval() {
        return currval;
    }

    public void setCurrval(Integer currval) {
        this.currval = currval;
    }

    public Integer getNextval() {
        return nextval;
    }

    public void setNextval(Integer nextval) {
        this.nextval = nextval;
    }

    public Integer getIncrease() {
        return increase;
    }

    public void setIncrease(Integer increase) {
        this.increase = increase;
    }

    public Integer getInitval() {
        return initval;
    }

    public void setInitval(Integer initval) {
        this.initval = initval;
    }

    public Integer getMaxval() {
        return maxval;
    }

    public void setMaxval(Integer maxval) {
        this.maxval = maxval;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle == null ? null : cycle.trim();
    }
}