
package com.bpaas.bps.user.mapper;

import java.util.List;

import com.bpaas.bps.user.po.UsrRewardsDtlsPo;

public interface UsrRewardsDtlsMapper {

	int insert(UsrRewardsDtlsPo usrRewardsDtlsPo);
	
	int update(UsrRewardsDtlsPo usrRewardsDtlsPo);
	
	int delete(UsrRewardsDtlsPo usrRewardsDtlsPo);
	
	UsrRewardsDtlsPo selectOne(UsrRewardsDtlsPo usrRewardsDtlsPo);

	List<UsrRewardsDtlsPo> selectList(UsrRewardsDtlsPo usrRewardsDtlsPo);
	
	int updateByEntity(UsrRewardsDtlsPo usrRewardsDtlsVal, UsrRewardsDtlsPo usrRewardsDtlsCon);
	
}


