package com.bpaas.bps.user.mapper;

import java.util.List;

import com.bpaas.bps.user.po.UsrSignPo;

/**
 * 用户签到信息表
 * @author fei.meng
 *
 */
public interface UsrSignMapper {
	
	int insert(UsrSignPo usrSignPo);
	
	int delete(UsrSignPo usrSignPo);
	
	UsrSignPo selectOne(UsrSignPo usrSignPo);
	
	List<UsrSignPo> selectList(UsrSignPo usrSignPo);
	
}
