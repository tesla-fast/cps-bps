package com.bpaas.bps.user.common.mapper;

import java.util.List;

import com.bpaas.bps.user.common.po.UsrChnlBaseInfoPo;

/**
 * 渠道用户基本信息表
 */
public interface UsrChnlBaseInfoMapper {

	int insert(UsrChnlBaseInfoPo usrChnlBaseInfoPo);
	
	int update(UsrChnlBaseInfoPo usrChnlBaseInfoPo);
	
	int updateByEntity(UsrChnlBaseInfoPo usrChnlBaseInfoVal, UsrChnlBaseInfoPo usrChnlBaseInfoCon);
	
	int delete(UsrChnlBaseInfoPo usrChnlBaseInfoPo);
	
	UsrChnlBaseInfoPo selectOne(UsrChnlBaseInfoPo usrChnlBaseInfoPo);
	
	List<UsrChnlBaseInfoPo> selectList(UsrChnlBaseInfoPo usrChnlBaseInfoPo);
	
}