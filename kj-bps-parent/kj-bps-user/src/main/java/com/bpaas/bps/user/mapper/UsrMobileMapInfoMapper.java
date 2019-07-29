
package com.bpaas.bps.user.mapper;

import java.util.List;

import com.bpaas.bps.user.po.UsrMobileMapInfoPo;

public interface UsrMobileMapInfoMapper {
	
	int insert(UsrMobileMapInfoPo usrMobileMapInfoPo);
	
	int update(UsrMobileMapInfoPo usrMobileMapInfoPo);
	
	int updateByEntity(UsrMobileMapInfoPo usrMobileMapInfoVal, UsrMobileMapInfoPo usrMobileMapInfoCon);
	
	int delete(UsrMobileMapInfoPo usrMobileMapInfoPo);
	
	UsrMobileMapInfoPo selectOne(UsrMobileMapInfoPo usrMobileMapInfoPo);
	
	List<UsrMobileMapInfoPo> selectList(UsrMobileMapInfoPo usrMobileMapInfoPo);
	
}