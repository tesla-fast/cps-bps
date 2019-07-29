package com.bpaas.bps.base.mapper;

import com.bpaas.bps.base.po.gnr.GnrSequencesPo;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description:
 * @version: 1.0
 */
public interface GnrSeqMapper {

    int insert(GnrSequencesPo gnrSequencesPo);

    GnrSequencesPo select(GnrSequencesPo gnrSequencesPo);

    int update(GnrSequencesPo gnrSequencesPo);
}
