package com.bpaas.bps.pay.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.common.constants.Constants_wechat;
import com.bpaas.bps.common.utils.WechatPayUtil;
import com.bpaas.bps.httpclient.HttpTools;
import com.bpaas.bps.pay.config.WechatAppConfig;
import com.bpaas.bps.pay.service.AppPayService;
import com.bpaas.bps.pay.vo.wechat.WechatAppVo;

/**
 * @Author: Jason
 * @Date: 2019/07/05
 * @Description:
 * @version: 1.0
 */
@Service("WechatAppService")
public class WechatAppServiceImpl implements AppPayService {
	private static final Logger logger = LoggerFactory.getLogger(WechatAppServiceImpl.class);
	
	@Autowired
	private WechatAppConfig cfg;
	
	/**
	 * 微信APP支付，统一下单
	 * @param obj-表现层对象（保存客户端请求数据）
	 * @return JSONObject-包括预支付交易会话标识等
	 */
	@Override
	public CommonResult<JSONObject> createPayOrder(Object obj) {
		CommonResult<JSONObject> cr = null;
		try {
			WechatAppVo vo = (WechatAppVo)obj;
			Map<String, String> initData = new HashMap<String, String>();
			addComNode(initData);
			initData.put("body", vo.getBody());
			initData.put("out_trade_no", vo.getOutTradeNo());
			initData.put("fee_type", vo.getFeeType());
			initData.put("total_fee", vo.getTotalAmount());
			initData.put("spbill_create_ip", vo.getSpbillCreateIp());
			initData.put("trade_type", vo.getFeeType());
			initData.put("notify_url", cfg.getNotifyUrl());
			String sign = WechatPayUtil.createSign(initData, cfg.getMchKey());
			initData.put("sign", sign);
			String response = HttpTools.post(cfg.getUnifiedorder(), JSONObject.toJSONString(initData), 30000, 30000);
			logger.debug("response: {}", response);
		} catch (Exception e) {
			logger.error("调用微信APP支付，统一下单API异常：{}", e);
			cr = CommonResult.failed("用微信APP支付，统一下单API异常！");
		}
		return cr;
	}

	/**
	 * 微信APP支付，查询订单信息
	 * @param obj-表现层对象（保存客户端请求数据）,列如：订单号码
	 * @return JSONObject-订单付款状态信息
	 */
	@Override
	public CommonResult<JSONObject> queryPayOrderStatus(Object obj) {
		CommonResult<JSONObject> cr = null;
		try {
			WechatAppVo vo = (WechatAppVo)obj;
			Map<String, String> initData = new HashMap<String, String>();
			addComNode(initData);
			initData.put("out_trade_no", vo.getOutTradeNo());
			String sign = WechatPayUtil.createSign(initData, cfg.getMchKey());
			initData.put("sign", sign);
			String response = HttpTools.post(cfg.getOrderquery(), JSONObject.toJSONString(initData), 30000, 30000);
			logger.debug("response: {}", response);
		} catch (Exception e) {
			logger.error("调用微信APP支付，订单查询API异常：{}", e);
			cr = CommonResult.failed("调用微信APP支付，订单查询API异常！");
		}
		return cr;
	}

	/**
	 * 微信APP支付，异步通知订单付款结果
	 * @param obj-保存微信异步通知数据
	 * @return rspMsg-返回商户后台处理结果（成功-SUCC，失败-FAIL）
	 */
	@Override
	public String recevieNotify(Object obj) {
		String rspMsg = null;
		try {
			String data = (String)obj;
			Map<String, String> mapData = WechatPayUtil.xmlToMap(data);
			String srcSign = (String)mapData.get(Constants_wechat.FIELD_SIGN);
			mapData.remove(Constants_wechat.FIELD_SIGN);
			String dstSign = WechatPayUtil.createSign(mapData, cfg.getMchKey());
			if (srcSign.equals(dstSign)) {
				logger.debug("验签成功");
				/*开始进行业务逻辑处理，更新支付结果信息....*/
				
				
				rspMsg = resultSuccess();
			} else {
				logger.debug("验签失败");
				rspMsg = resultFail("验签失败");
			}
		} catch (Exception e) {
			logger.debug("微信支付异步通知处理异常：{}", e);
			rspMsg =resultFail("微信支付异步通知处理异常");
		}
		return rspMsg;
	}

	
	public Map<String, String> addComNode(Map<String, String> data) {
		data.put("appid", cfg.getAppId());
		data.put("mch_id", cfg.getMchId());
		data.put("nonce_str", WechatPayUtil.generateUUID());
		data.put("sign_type", cfg.getSigntype());
		return data;
	}
	
	public String resultSuccess() {
		Map<String, String> rspData = new HashMap<String, String>();
		rspData.put("return_code", Constants_wechat.SUCCESS);
		rspData.put("return_msg", "OK");
		return WechatPayUtil.convertMapToXmlTag(rspData, false);
	}
	
	public String resultFail(String errMsg) {
		Map<String, String> rspData = new HashMap<String, String>();
		rspData.put("return_code", Constants_wechat.FAIL);
		rspData.put("return_msg", errMsg);
		return WechatPayUtil.convertMapToXmlTag(rspData, false);
	}
}
