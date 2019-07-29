package com.bpaas.bps.common.utils;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 基础工具类
 * @version: 1.0
 */
public class BaseUtil {

    public static String leftPad(String str, String numStr, int len) {
        // numStr已超出长度如何处理？
        String formater = "%".concat(str).concat(len + "").concat("d");
        return String.format(formater, Long.valueOf(numStr));
    }
}
