package com.bpaas.bps.pay.mapper.alipay;

import java.util.List;

import com.bpaas.bps.pay.po.alipay.AlipayOrderPo;

/**
 * @Author: Jason
 * @Date: 2019/07/04
 * @Description:
 * @version: 1.0
 */
public interface AlipayOrderMapper {

	int insert(AlipayOrderPo AlipayOrderPo);
	
	int updateByEntity(AlipayOrderPo AlipayOrderVal, AlipayOrderPo AlipayOrderCon);
	
	int delete(AlipayOrderPo AlipayOrderPo);
	
	AlipayOrderPo selectOne(AlipayOrderPo AlipayOrderPo);
	
	List<AlipayOrderPo> selectList(AlipayOrderPo AlipayOrderPo);
	
}
