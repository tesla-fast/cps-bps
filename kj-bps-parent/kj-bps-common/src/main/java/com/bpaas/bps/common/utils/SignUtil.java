package com.bpaas.bps.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;
import java.util.Map.Entry;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 微信支付签名工具类
 * @version: 1.0
 */
public class SignUtil {

    /**
     * 生成签名
     * @param map
     * @return
     */
    public static String getSign(Map<String, Object> map, String appKey) {

        String result = "";
        try {
            List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(map.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>() {

                public int compare(Map.Entry<String, Object> o1, Map.Entry<String, Object> o2) {
                    return (o1.getKey()).toString().compareTo(o2.getKey());
                }
            });

            // 构造签名键值对的格式
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> item : infoIds) {
                if (item.getKey() != null || item.getKey() != "") {
                    String key = item.getKey();
                    String val = (String)item.getValue();
                    if (!("".equals(val) || val == null || key.equals("_TRAN_CODE"))) {
                        sb.append(key + "=" + val + "&");
                    }
                }

            }
//			sb.append(PropertyManager.getProperty("SIGNKEY"));
            result = sb.toString()+"key="+appKey;

            //进行MD5加密
            result = DigestUtils.md5Hex(result).toUpperCase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return result;
    }
    
    
    public static String signDataProcss(String appSecret, String charset, Map<String, Object> parameters) throws Exception {
		SortedMap<String, Object> paramData = new TreeMap<String, Object>();
		paramData.putAll(parameters);
		StringBuffer sb = new StringBuffer();
        Set<Entry<String, Object>> es = paramData.entrySet();
        Iterator<Entry<String, Object>> it = es.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
        	if (!it.hasNext()) {
        		sb.append(k).append("=").append(v);
        	} else {
        		sb.append(k).append("=").append(v).append("&");
        	}
        }
        System.out.println("--->" + sb.toString());
		Mac mac = Mac.getInstance("HmacSHA1");
		SecretKeySpec secretKey = new SecretKeySpec(appSecret.getBytes(charset), mac.getAlgorithm());
		mac.init(secretKey);
		byte[] hash = mac.doFinal(sb.toString().getBytes(charset));
		return org.apache.commons.codec.binary.Base64.encodeBase64String(hash);
	}
}
