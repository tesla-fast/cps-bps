package com.bpaas.bps.base.mapper;

import com.bpaas.bps.base.po.gnr.GnrParmPo;

public interface GnrParmPoMapper {
    int deleteByPrimaryKey(String id);

    int insert(GnrParmPo record);

    int insertSelective(GnrParmPo record);

    GnrParmPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GnrParmPo record);

    int updateByPrimaryKey(GnrParmPo record);
}