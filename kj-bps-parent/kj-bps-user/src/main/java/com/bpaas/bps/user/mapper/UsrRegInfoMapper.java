package com.bpaas.bps.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bpaas.bps.user.po.UsrRegInfoPo;

public interface UsrRegInfoMapper {
	
	int insert(UsrRegInfoPo usrRegInfoPo);
	
	int update(@Param("s") UsrRegInfoPo usrRegInfoVal, @Param("w") UsrRegInfoPo usrRegInfoCon);
	
	int delete(UsrRegInfoPo usrRegInfoPo);
	
	UsrRegInfoPo selectOne(UsrRegInfoPo usrRegInfoPo);
	
	List<UsrRegInfoPo> selectList(UsrRegInfoPo usrRegInfoPo);
	
}
