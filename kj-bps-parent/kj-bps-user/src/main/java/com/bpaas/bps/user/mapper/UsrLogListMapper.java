package com.bpaas.bps.user.mapper;

import java.util.List;

import com.bpaas.bps.user.po.UsrLogListPo;

public interface UsrLogListMapper {

	int insert(UsrLogListPo usrLogListPo);
	
	int update(UsrLogListPo usrLogListPo);
	
	int updateByEntity(UsrLogListPo usrLogListVal, UsrLogListPo usrLogListCon);
	
	int delete(UsrLogListPo usrLogListPo);
	
	UsrLogListPo selectOne(UsrLogListPo usrLogListPo);
	
	List<UsrLogListPo> selectList(UsrLogListPo usrLogListPo);
	
}
