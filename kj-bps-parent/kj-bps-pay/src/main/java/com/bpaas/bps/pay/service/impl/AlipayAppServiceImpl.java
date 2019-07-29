package com.bpaas.bps.pay.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.common.constants.Constants_alipay;
import com.bpaas.bps.pay.config.AlipayAppConfig;
import com.bpaas.bps.pay.service.AppPayService;
import com.bpaas.bps.pay.vo.alipay.AlipayAppVo;

/**
 * @Author: Jason
 * @Date: 2019/07/04
 * @Description:
 * @version: 1.0
 */
@Service("AlipayAppService")
public class AlipayAppServiceImpl implements AppPayService {
	private static final Logger logger = LoggerFactory.getLogger(AlipayAppServiceImpl.class);
	
	@Autowired
	private AlipayAppConfig cfg;
	
	/**
	 * 创建支付宝订单
	 * @param obj-表现层对象（保存客户端请求数据）
	 * @return JSONObject-签名字符串
	 */
	@Override
	public CommonResult<JSONObject> createPayOrder(Object obj) {
		CommonResult<JSONObject> cr = null;
		try {
			AlipayAppVo vo = (AlipayAppVo)obj;
			AlipayClient alipayClient = new DefaultAlipayClient(cfg.getServerUrl(), cfg.getAppId(), cfg.getPrivateKey(), cfg.getFormat(), cfg.getCharset(), cfg.getAlipayPublicKey(), cfg.getSignType());
			AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
			AlipayTradeAppPayModel bizModel = new AlipayTradeAppPayModel();
			bizModel.setSubject("支付宝APP支付");
			bizModel.setProductCode("QUICK_MSECURITY_PAY");
			bizModel.setOutTradeNo(vo.getOutTradeNo());
			bizModel.setTotalAmount(vo.getTotalAmount());
			alipayRequest.setBizModel(bizModel);
			alipayRequest.setNotifyUrl(cfg.getNotifyUrl());
			AlipayTradeAppPayResponse sdkExecute = alipayClient.sdkExecute(alipayRequest);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("aliOrderStr", sdkExecute.getBody());
			cr = CommonResult.success((JSONObject)JSONObject.toJSON(data), "success");
		} catch(Exception e) {
			logger.error("支付宝APP支付下单异常：{}", e);
			cr = CommonResult.failed("alipay online ordery exception");
		}
		return cr;
	}

	/**
	 * 支付宝订单状态查询
	 * @param obj-表现层对象（保存客户端请求数据）,列如：订单号码
	 * @return JSONObject-订单付款状态信息
	 */
	@Override
	public CommonResult<JSONObject> queryPayOrderStatus(Object obj) {
		CommonResult<JSONObject> cr = null;
		try {
			AlipayAppVo vo = (AlipayAppVo)obj;
			AlipayClient alipayClient = new DefaultAlipayClient(cfg.getServerUrl(), cfg.getAppId(), cfg.getPrivateKey(), cfg.getFormat(), cfg.getCharset(), cfg.getAlipayPublicKey(), cfg.getSignType());
			AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
			AlipayTradeQueryModel bizModel = new AlipayTradeQueryModel();
			bizModel.setOutTradeNo(vo.getOutTradeNo());
			alipayRequest.setBizModel(bizModel);
			AlipayTradeQueryResponse alipayResponse = alipayClient.execute(alipayRequest);
			logger.debug("支付宝网关返回码：{}，返回码描述：{}", alipayResponse.getCode(), alipayResponse.getMsg());
			logger.debug("支付宝业务返回码：{}，返回码描述：{}", alipayResponse.getSubCode(), alipayResponse.getSubMsg());
			if (alipayResponse.isSuccess()) {
				@SuppressWarnings("unchecked")
				Map<String, Object> parseObject = JSONObject.parseObject(alipayResponse.getBody(), Map.class);
				parseObject.get("alipay_trade_query_response");
			} else {
				cr = CommonResult.failed(alipayResponse.getSubMsg());
			}
		} catch (Exception e) {
			logger.error("调用支付宝订单查询API异常：{}", e);
			cr = CommonResult.failed("调用支付宝订单查询API异常！");
		}
		return cr;
	}

	/**
	 * 支付宝APP支付，异步通知订单付款结果
	 * @param obj-保存支付宝异步通知数据
	 * @return rspMsg-返回商户后台处理结果（成功-SUCC，失败-FAIL）
	 */
	@Override
	public String recevieNotify(Object obj) {
		String rspMsg = null;
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> data = (HashMap<String, String>)obj;
			boolean rsaCheckV1 = AlipaySignature.rsaCheckV1(data, cfg.getAlipayPublicKey(), cfg.getCharset(), cfg.getSignType());
			if (rsaCheckV1) {
				logger.debug("验签成功");
				/*开始进行业务逻辑处理，更新支付结果信息...*/
				
				rspMsg = Constants_alipay.SUCC;
			} else {
				logger.debug("验签失败");
				rspMsg = Constants_alipay.FAIL;
			}
		} catch (Exception e) {
			logger.debug("支付宝异步通知处理异常：{}", e);
			rspMsg = Constants_alipay.FAIL;
		}
		return rspMsg;
	}

}
