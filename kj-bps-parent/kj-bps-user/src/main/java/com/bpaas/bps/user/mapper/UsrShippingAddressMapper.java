package com.bpaas.bps.user.mapper;

import java.util.List;

import com.bpaas.bps.user.po.UsrShippingAddressPo;

/**
 * 配送地址
 * @author haowen.wang
 *
 */
public interface UsrShippingAddressMapper {
	
	int insert(UsrShippingAddressPo usrShippingAddressPo);
	
	int update(UsrShippingAddressPo usrShippingAddressPo);
	
	int delete(UsrShippingAddressPo usrShippingAddressPo);
	
	UsrShippingAddressPo selectOne(UsrShippingAddressPo usrShippingAddressPo);
	
	List<UsrShippingAddressPo> selectList(UsrShippingAddressPo usrShippingAddressPo);
	
}
