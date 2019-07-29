package com.bpaas.bps.pay.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.pay.service.AppPayService;
import com.bpaas.bps.pay.vo.alipay.AlipayAppVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @Author: Jason
 * @Date: 2019/07/04
 * @Description:
 * @version: 1.0
 */
@Api(tags="支付宝APP支付接口集")
@RestController
public class AlipayAppController {
	private static final Logger logger = LoggerFactory.getLogger(AlipayAppController.class);

	@Autowired
	@Qualifier("AlipayAppService")
	private AppPayService appPayService;

	
	/**
     * 功能描述: 支付宝APP下单
     * @param: userId，outTradeNo，totalAmount
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/04
     */
	@ApiOperation(value = "支付宝APP下单", httpMethod = "POST", notes = "支付宝APP下单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "body"),
		@ApiImplicitParam(name = "outTradeNo", value = "订单号码", required = true, paramType = "body"),
		@ApiImplicitParam(name = "totalAmount", value = "订单总金额", required = true, paramType = "body")
	})
	@RequestMapping(value = "/createAlipayAppOrder", method = RequestMethod.POST)
	public CommonResult<JSONObject> createAlipayOrder(@RequestBody AlipayAppVo vo) {
		logger.debug("alipay App createAlipayAppOrder...");
		return appPayService.createPayOrder(vo);
	}

	/**
     * 功能描述: 支付宝订单查询
     * @param: userId，outTradeNo
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/04
     */
	@ApiOperation(value = "支付宝订单查询", httpMethod = "POST", notes = "支付宝订单查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "body"),
		@ApiImplicitParam(name = "outTradeNo", value = "订单号码", required = true, paramType = "body"),
	})
	@RequestMapping(value = "/queryAlipayAppOrderStatus", method = RequestMethod.POST)
	public CommonResult<JSONObject> queryAlipayOrderStatu(@RequestBody AlipayAppVo vo) {
		logger.debug("alipay App queryAlipayAppOrderStatus...");
		return appPayService.queryPayOrderStatus(vo);
	}

	/**
     * 功能描述: 支付宝异步通知
     * @param: reqData
     * @return: success/fail
     * @author: Jason
     * @date: 2019/07/04
     */
	@ApiOperation(value = "支付宝异步通知", httpMethod = "POST", notes = "支付宝异步通知")
	@RequestMapping(value = "/recevieAlipayAppNotify", method = RequestMethod.POST)
	public String recevieAlipayNotify(@RequestParam Map<String, String> reqData) {
		logger.debug("alipay App recevieAlipayAppNotify...");
		return appPayService.recevieNotify(reqData);
	}

}
