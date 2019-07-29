package com.bpaas.bps.user.mapper;

import java.util.List;

import com.bpaas.bps.user.po.UsrCustomerInfoPo;

/**
 * 客户信息
 * @author haowen.wang
 *
 */
public interface UsrCustomerInfoMapper {

	int insert(UsrCustomerInfoPo usrCustomerInfoPo);
	
	int update(UsrCustomerInfoPo usrCustomerInfoPo);

	int delete(UsrCustomerInfoPo usrCustomerInfoPo);
	
	UsrCustomerInfoPo selectOne(UsrCustomerInfoPo usrCustomerInfoPo);
	
	List<UsrCustomerInfoPo> selectList(UsrCustomerInfoPo usrCustomerInfoPo);
	
}

