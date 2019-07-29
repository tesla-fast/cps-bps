package com.bpaas.bps.common.utils;

import java.util.Map;

public class InitData {

	public static Map<String, Object> success(Map<String, Object> cache) {
		cache.put("PS@RSPCODE", "000000");
		cache.put("PS@RPSMSG", "交易成功");
		return cache;
	}
	
	public static Map<String, Object> fail(Map<String, Object> cache, String msg) {
		cache.put("PS@RSPCODE", "999999");
		cache.put("PS@RPSMSG", "交易失败");
		if (null != msg) {
			cache.put("PS@RPSMSG", msg);
		}
		return cache;
	}
	
}
