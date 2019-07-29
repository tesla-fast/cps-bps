package com.bpaas.bps.user.common.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bpaas.bps.common.utils.SignUtil;
import com.bpaas.bps.common.utils.StringUtil;
import com.bpaas.bps.httpclient.BpsDefaultHttpClient;
import com.bpaas.bps.httpclient.BpsHttpClient;
import com.bpaas.bps.user.common.config.CloudwalkConfig;
import com.bpaas.bps.user.common.service.CloudwalkService;

@Service("cloudwalkService")
public class CloudwalkServiceImpl implements CloudwalkService<Map<String, Object>> {
	private static final Logger logger = LoggerFactory.getLogger(CloudwalkServiceImpl.class);

	@Autowired
	private CloudwalkConfig cfg;

	@Override
	public Map<String, Object> faceCompare(Map<String, Object> cache) throws Exception {
		Map<String, Object> prepareData = new HashMap<String, Object>();
		prepareData.put("appKey", cfg.getAppKey());
		prepareData.put("nonceStr", StringUtil.createStr());
		prepareData.put("imgA", cache.get("imgA"));
		prepareData.put("imgB", cache.get("imgB"));
		prepareData.put("uri", "/ai-cloud-face/face/tool/compare");
		try {
			prepareData.put("sign", SignUtil.signDataProcss(cfg.getAppSecret(), cfg.getCharset(), prepareData));
		} catch (Exception e) {
			logger.error("人脸比对，请求参数加密异常: {}", e);
			throw new RuntimeException("人脸比对，请求参数加密异常");
		}

		BpsHttpClient bpsHttpClient = new BpsDefaultHttpClient(cfg.getFaceCompareUrl());
		Map<String, Object> rspData = bpsHttpClient.doPost(prepareData);
		String statusCode = rspData.get("statusCode").toString();
		String rspBody = (String) rspData.get("rspBody");
		JSONObject jsonObj = null;
		if (StringUtils.isNotBlank(rspBody)) {
			jsonObj = JSONObject.parseObject(rspBody);
		}
		if ("999".equals(statusCode)) {
			throw new RuntimeException(rspData.get("errorMsg").toString());
		} else if (!"200".equals(statusCode)) {
			throw new RuntimeException(jsonObj.getString("message"));
		}

		if ("0".equals(jsonObj.get("code").toString())) {
			JSONObject jsonData = (JSONObject) jsonObj.get("data");
			double num = Double.parseDouble(jsonData.get("score").toString());
			logger.info("人脸比对，云从返回相似度数据: {}", num);
			if (num > 0.7) {
				cache.put("faceCode", "0");
				cache.put("faceMsg", "人脸比对成功");
			} else {
				throw new RuntimeException("相似度太低了");
			}
		} else {
			throw new RuntimeException((String) jsonObj.get("message"));
		}
		return cache;
	}

}
