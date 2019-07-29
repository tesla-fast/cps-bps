package com.bpaas.bps.user.common.mapper;

import java.util.List;

import com.bpaas.bps.user.common.po.UsrLogListPo;

public interface UsrLogListMapper {

	int insert(UsrLogListPo usrLogListPo);
	
	int update(UsrLogListPo usrLogListVal, UsrLogListPo usrLogListCon);
	
	int delete(UsrLogListPo usrLogListPo);
	
	UsrLogListPo selectOne(UsrLogListPo usrLogListPo);
	
	List<UsrLogListPo> selectList(UsrLogListPo usrLogListPo);
	
}
