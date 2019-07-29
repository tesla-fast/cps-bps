package com.bpaas.bps.user.common.mapper;

import java.util.List;

import com.bpaas.bps.user.common.po.UsrWhitePo;

public interface UsrWhiteMapper {

	int insert(UsrWhitePo usrWhitePo);
	
	int delete(UsrWhitePo usrWhitePo);
	
	UsrWhitePo selectOne(UsrWhitePo usrWhitePo);
	
	List<UsrWhitePo> selectList(UsrWhitePo usrWhitePo);
	
}