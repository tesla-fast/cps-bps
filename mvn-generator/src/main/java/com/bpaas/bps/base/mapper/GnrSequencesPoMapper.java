package com.bpaas.bps.base.mapper;

import com.bpaas.bps.base.po.gnr.GnrSequencesPo;

public interface GnrSequencesPoMapper {
    int deleteByPrimaryKey(String id);

    int insert(GnrSequencesPo record);

    int insertSelective(GnrSequencesPo record);

    GnrSequencesPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GnrSequencesPo record);

    int updateByPrimaryKey(GnrSequencesPo record);
}