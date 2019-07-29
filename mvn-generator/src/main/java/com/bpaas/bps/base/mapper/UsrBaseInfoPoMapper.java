package com.bpaas.bps.base.mapper;

import com.bpaas.bps.base.po.gnr.UsrBaseInfoPo;
import com.bpaas.bps.base.po.gnr.UsrBaseInfoPoWithBLOBs;

public interface UsrBaseInfoPoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsrBaseInfoPoWithBLOBs record);

    int insertSelective(UsrBaseInfoPoWithBLOBs record);

    UsrBaseInfoPoWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsrBaseInfoPoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UsrBaseInfoPoWithBLOBs record);

    int updateByPrimaryKey(UsrBaseInfoPo record);
}