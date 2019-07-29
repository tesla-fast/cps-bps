package com.bpaas.bps.pay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.pay.service.AppPayService;
import com.bpaas.bps.pay.vo.wechat.WechatAppVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @Author: Jason
 * @Date: 2019/07/05
 * @Description:
 * @version: 1.0
 */
@Api(tags="微信APP支付接口集")
@RestController
public class WechatAppController {

	public static final Logger logger = LoggerFactory.getLogger(WechatAppController.class);
	
	@Autowired
	@Qualifier("WechatAppService")
	private AppPayService appPayService;
	
	/**
     * 功能描述: 微信APP下单
     * @param: userId，outTradeNo，totalAmount
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/04
     */
	@ApiOperation(value = "微信APP下单", httpMethod = "POST", notes = "微信APP下单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "body"),
		@ApiImplicitParam(name = "outTradeNo", value = "订单号码", required = true, paramType = "body"),
		@ApiImplicitParam(name = "totalAmount", value = "订单总金额", required = true, paramType = "body")
	})
	@RequestMapping(value = "/createWechatAppOrder", method = RequestMethod.POST)
	public CommonResult<JSONObject> createWechatOrder(@RequestBody WechatAppVo vo) {
		logger.debug("Wechat App createWechatAppOrder...");
		return appPayService.createPayOrder(vo);
	}
	
	/**
     * 功能描述: 微信APP支付订单查询
     * @param: userId，outTradeNo
     * @return: WechatAppVo
     * @author: JSONObject
     * @date: 2019/07/04
     */
	@ApiOperation(value = "微信APP支付订单查询", httpMethod = "POST", notes = "微信APP支付订单查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "body"),
		@ApiImplicitParam(name = "outTradeNo", value = "订单号码", required = true, paramType = "body"),
	})
	@RequestMapping(value = "/queryWechatAppOrderStatus", method = RequestMethod.POST)
	public CommonResult<JSONObject> queryWechatOrderStatu(@RequestBody WechatAppVo vo) {
		logger.debug("Wechat App queryWechatAppOrderStatus...");
		return appPayService.queryPayOrderStatus(vo);
	}
	
	/**
     * 功能描述: 微信APP支付异步通知
     * @param: reqData
     * @return: success/fail
     * @author: Jason
     * @date: 2019/07/04
     */
	@ApiOperation(value = "微信APP支付异步通知", httpMethod = "POST", notes = "微信APP支付异步通知")
	@RequestMapping(value = "/recevieWechatAppNotify", method = RequestMethod.POST)
	public String recevieWechatNotify(@RequestBody String reqData) {
		logger.debug("Wechat App recevieWechatAppNotify...");
		return appPayService.recevieNotify(reqData);
	}
	
}
