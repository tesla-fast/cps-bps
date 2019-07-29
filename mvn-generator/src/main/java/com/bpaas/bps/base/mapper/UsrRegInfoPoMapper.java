package com.bpaas.bps.base.mapper;

import com.bpaas.bps.base.po.gnr.UsrRegInfoPo;

public interface UsrRegInfoPoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsrRegInfoPo record);

    int insertSelective(UsrRegInfoPo record);

    UsrRegInfoPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsrRegInfoPo record);

    int updateByPrimaryKey(UsrRegInfoPo record);
}