package com.bpaas.bps.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;

/**
 * 对接支付宝/微信APP支付，对外提供相关的支付接口
 * 
 * @author Jason
 * @date 2019/07/03
 */
public interface AppPayService {

	public CommonResult<JSONObject> createPayOrder(Object obj);
	
	public CommonResult<JSONObject> queryPayOrderStatus(Object obj);
	
	public String recevieNotify(Object obj);

}
