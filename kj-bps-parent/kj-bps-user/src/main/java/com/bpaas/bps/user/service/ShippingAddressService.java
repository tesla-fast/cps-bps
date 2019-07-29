package com.bpaas.bps.user.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;

/**
 * @Author Jason
 * @Date 2019/7/12
 * @Description 客户收货地址，接口列表
 * @version 1.0
 */
public interface ShippingAddressService {

	/**
	 * 客户新增收货地址
	 * @param shippingAddressVo
	 * @return 200-操作成功，500-操作失败
	 */
	public CommonResult<JSONObject> addAddress(Map<String, Object> reqData);
	
	/**
	 * 根据UserId查询收货地址
	 * @param shippingAddressVo
	 * @return 根据查询条件，返回对应收货地址
	 */
	public CommonResult<JSONObject> queryAddressByUser(Map<String, Object> reqData);
	
	/**
	 * 客户更新收货地址
	 * @param shippingAddressVo
	 * @return 200-操作成功，500-操作失败
	 */
	public CommonResult<JSONObject> updateAddress(Map<String, Object> reqData);
	
	/**
	 * 客户删除收货地址
	 * @param shippingAddressVo
	 * @return 200-操作成功，500-操作失败 
	 */
	public CommonResult<JSONObject> deleteAddress(Map<String, Object> reqData);
	
	/**
	 * 根据收货ID查询收货地址信息
	 * @param shippingAddressVo
	 * @return 返回对应收货地址
	 */
	public CommonResult<JSONObject> queryAddressById(Map<String, Object> reqData);
	
}
