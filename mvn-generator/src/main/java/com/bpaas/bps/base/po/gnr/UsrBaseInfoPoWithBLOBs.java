package com.bpaas.bps.base.po.gnr;

public class UsrBaseInfoPoWithBLOBs extends UsrBaseInfoPo {
    private String picHead;

    private String picCertFront;

    private String picCertBack;

    public String getPicHead() {
        return picHead;
    }

    public void setPicHead(String picHead) {
        this.picHead = picHead == null ? null : picHead.trim();
    }

    public String getPicCertFront() {
        return picCertFront;
    }

    public void setPicCertFront(String picCertFront) {
        this.picCertFront = picCertFront == null ? null : picCertFront.trim();
    }

    public String getPicCertBack() {
        return picCertBack;
    }

    public void setPicCertBack(String picCertBack) {
        this.picCertBack = picCertBack == null ? null : picCertBack.trim();
    }
}