package com.bpaas.bps.user.mapper;

import java.util.List;

import com.bpaas.bps.user.po.UsrLockBookPo;

public interface UsrLockBookMapper {

	int insert(UsrLockBookPo usrLockBookPo);
	
	int update(UsrLockBookPo usrLockBookPo);
	
	int updateByEntity(UsrLockBookPo usrLockBookVal, UsrLockBookPo usrLockBookCon);
	
	int delete(UsrLockBookPo usrLockBookPo);
	
	UsrLockBookPo selectOne(UsrLockBookPo usrLockBookPo);
	
	List<UsrLockBookPo> selectList(UsrLockBookPo usrLockBookPo);
}

