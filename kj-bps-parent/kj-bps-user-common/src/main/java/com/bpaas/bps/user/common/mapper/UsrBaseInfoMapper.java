package com.bpaas.bps.user.common.mapper;

import java.util.List;

import com.bpaas.bps.user.common.po.UsrBaseInfoPo;

public interface UsrBaseInfoMapper {

	int insert(UsrBaseInfoPo usrBaseInfoPo);
	
	int update(UsrBaseInfoPo usrBaseInfoPo);
	
	int updateByEntity(UsrBaseInfoPo usrBaseInfoVal, UsrBaseInfoPo usrBaseInfoCon);
	
	int delete(UsrBaseInfoPo usrBaseInfoPo);
	
	UsrBaseInfoPo selectOne(UsrBaseInfoPo usrBaseInfoPo);
	
	List<UsrBaseInfoPo> selectList(UsrBaseInfoPo usrBaseInfoPo);
	
}

