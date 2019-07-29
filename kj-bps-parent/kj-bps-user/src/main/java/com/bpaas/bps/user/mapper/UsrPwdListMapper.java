package com.bpaas.bps.user.mapper;

import java.util.List;

import com.bpaas.bps.user.po.UsrPwdListPo;

public interface UsrPwdListMapper {

	int insert(UsrPwdListPo usrPwdListPo);
	
	int update(UsrPwdListPo usrPwdListPo);
	
	int updateByEntity(UsrPwdListPo usrPwdListVal, UsrPwdListPo usrPwdListCon);
	
	int delete(UsrPwdListPo usrPwdListPo);
	
	UsrPwdListPo selectOne(UsrPwdListPo usrPwdListPo);
	
	List<UsrPwdListPo> selectList(UsrPwdListPo usrPwdListPo);
	
}