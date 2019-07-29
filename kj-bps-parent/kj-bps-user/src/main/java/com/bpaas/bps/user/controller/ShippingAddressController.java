package com.bpaas.bps.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.user.service.ShippingAddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @Author: Jason
 * @Date: 2019/07/16
 * @Description:
 * @version: 1.0
 */
@Api(tags="用户收货地址管理")
@RestController
public class ShippingAddressController {
	
	@Autowired
	private ShippingAddressService shippingAddressService;
	
	/**
     * 功能描述: 客户新增收货地址
     * @param: ShippingAddressVo
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/16
     */
	@ApiOperation(value = "客户新增收货地址", httpMethod = "POST", notes = "客户新增收货地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "shippingUserName", value = "收货人姓名", required = true, paramType = "body"),
		@ApiImplicitParam(name = "contactMobile", value = "联系电话", required = true, paramType = "body"),
		@ApiImplicitParam(name = "city", value = "城市", required = true, paramType = "body"),
		@ApiImplicitParam(name = "state", value = "区/县", required = true, paramType = "body"),
		@ApiImplicitParam(name = "address", value = "收货地址", required = true, paramType = "body"),
		@ApiImplicitParam(name = "defaultFlag", value = "地址默认标志", required = true, paramType = "body")
	})
	@RequestMapping(value = "/createAlipayAppOrder", method = RequestMethod.POST)
	public CommonResult<JSONObject> addAddress(@RequestBody Map<String, Object> reqData) {
		return shippingAddressService.addAddress(reqData);
	}
	
	/**
     * 功能描述: 根据UserId查询收货地址
     * @param: userId
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/16
     */
	@ApiOperation(value = "根据UserId查询收货地址", httpMethod = "POST", notes = "根据UserId查询收货地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "body"),
	})
	@RequestMapping(value = "/queryAddressByUser", method = RequestMethod.POST)
	public CommonResult<JSONObject> queryAddressByUser(@RequestBody Map<String, Object> reqData) {
		return shippingAddressService.queryAddressByUser(reqData);
	}
	
	/**
     * 功能描述: 客户更新收货地址
     * @param: ShippingAddressVo
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/16
     */
	@ApiOperation(value = "客户更新收货地址", httpMethod = "POST", notes = "客户更新收货地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "body"),
		@ApiImplicitParam(name = "shippingUserName", value = "收货人姓名", required = true, paramType = "body"),
		@ApiImplicitParam(name = "contactMobile", value = "联系电话", required = true, paramType = "body"),
		@ApiImplicitParam(name = "city", value = "城市", required = true, paramType = "body"),
		@ApiImplicitParam(name = "state", value = "区/县", required = true, paramType = "body"),
		@ApiImplicitParam(name = "address", value = "收货地址", required = true, paramType = "body")
	})
	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public CommonResult<JSONObject> updateAddress(@RequestBody Map<String, Object> reqData) {
		return shippingAddressService.updateAddress(reqData);
	}
	
	/**
     * 功能描述: 客户删除收货地址
     * @param: shippingAddressId
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/16
     */
	@ApiOperation(value = "客户删除收货地址", httpMethod = "POST", notes = "客户删除收货地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "shippingAddressId", value = "收货地址ID", required = true, paramType = "body"),
	})
	@RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
	public CommonResult<JSONObject> deleteAddress(@RequestBody Map<String, Object> reqData) {
		return shippingAddressService.deleteAddress(reqData);
	}
	
	/**
     * 功能描述: 根据收货ID查询收货地址信息
     * @param: shippingAddressId
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/18
     */
	@ApiOperation(value = "根据收货ID查询收货地址信息", httpMethod = "POST", notes = "根据收货ID查询收货地址信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "shippingAddressId", value = "收货地址ID", required = true, paramType = "body"),
	})
	@RequestMapping(value = "/queryAddressById", method = RequestMethod.POST)
	public CommonResult<JSONObject> queryAddressById(@RequestBody Map<String, Object> reqData) {
		return shippingAddressService.queryAddressById(reqData);
	}
	
}
