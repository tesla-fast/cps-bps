package com.bpaas.bps.common.utils;

import com.alibaba.fastjson.JSONObject;

public class StringUtil {

	public static String toString(String val) {
		String[] split = val.split("\n");
		return JSONObject.parseObject(split[1]).getString("message");
	}

	public static String createStr() {
		String destStr = "";
		String soueStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] charArray = soueStr.toCharArray();
		for (int i = 0; i < 6; i++) {
			int idex = (int) (Math.random() * charArray.length);
			destStr += charArray[idex];
		}
		return destStr;
	}
}
