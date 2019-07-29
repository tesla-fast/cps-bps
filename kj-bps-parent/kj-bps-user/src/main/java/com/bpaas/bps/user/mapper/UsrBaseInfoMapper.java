package com.bpaas.bps.user.mapper;

import java.util.List;

import com.bpaas.bps.user.po.UsrBaseInfoPo;

public interface UsrBaseInfoMapper {
	
	int count(UsrBaseInfoPo usrBaseInfoPo);

	int insert(UsrBaseInfoPo usrBaseInfoPo);
	
	int update(UsrBaseInfoPo usrBaseInfoVal, UsrBaseInfoPo usrBaseInfoCon);
	
	int delete(UsrBaseInfoPo usrBaseInfoPo);
	
	UsrBaseInfoPo selectOne(UsrBaseInfoPo usrBaseInfoPo);
	
	List<UsrBaseInfoPo> selectList(UsrBaseInfoPo usrBaseInfoPo);
	
}

