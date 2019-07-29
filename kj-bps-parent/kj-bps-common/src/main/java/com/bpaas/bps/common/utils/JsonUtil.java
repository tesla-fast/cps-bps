package com.bpaas.bps.common.utils;

import org.json.JSONObject;
import org.json.XML;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: json工具类
 * @version: 1.0
 */
public class JsonUtil {

    public static String json2xml(String json) {
        JSONObject jsonObject = new JSONObject(json);
        return "<xml>" + XML.toString(jsonObject) + "<xml>";
    }
}
