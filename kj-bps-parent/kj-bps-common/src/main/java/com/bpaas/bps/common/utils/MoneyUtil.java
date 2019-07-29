package com.bpaas.bps.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 金额工具类
 * @version: 1.0
 */
public class MoneyUtil {

    /**
     * 四舍五入
     */
    public static final RoundingMode HALF_UP = RoundingMode.HALF_UP;
    /**
     * 向上取整
     */
    public static final RoundingMode UP = RoundingMode.UP;


    /**
     * 以元为单位的金额转换成分
     *
     * @param yuan
     * @param decimal
     * @return
     */
    public static BigDecimal transferY2F(BigDecimal yuan, int decimal) {

        StringBuffer transAmt = new StringBuffer("1");
        while (decimal > 0) {
            transAmt.append("0");
            decimal--;
        }

        if (yuan != null) {
            return multiply(yuan, new BigDecimal(transAmt.toString()), RoundingMode.DOWN, null).setScale(0);
        }

        return BigDecimal.ZERO;
    }


    /**
     * 以分为单位的金额转换成以元为单位
     *
     * @param fen
     * @return
     */
    public static BigDecimal transferF2Y(BigDecimal fen, int decimal) {

        StringBuffer transAmt = new StringBuffer("1");
        while (decimal > 0) {
            transAmt.append("0");
            decimal--;
        }

        if (fen != null) {
            return divide(fen, new BigDecimal(transAmt.toString()), RoundingMode.DOWN, null);
        }

        return BigDecimal.ZERO;
    }


    /**
     * 金额乘法
     *
     * @param first
     * @param second
     * @param roundingMode
     * @param scale
     * @return
     */
    public static BigDecimal multiply(BigDecimal first, BigDecimal second, RoundingMode roundingMode,
                                      Integer scale) {
        if (roundingMode == null) {
            roundingMode = MoneyUtil.HALF_UP;
        }
        if (first == null)
            first = BigDecimal.ZERO;
        if (second == null)
            second = BigDecimal.ZERO;
        if (scale == null)
            scale = 2;
        return (first.multiply(second)).setScale(scale, roundingMode);
    }


    /**
     * 金额除法
     *
     * @param first
     * @param second
     * @param roundingMode
     * @param scale
     * @return
     */
    public static BigDecimal divide(BigDecimal first, BigDecimal second, RoundingMode roundingMode,
                                    Integer scale) {
        if (roundingMode == null) {
            roundingMode = MoneyUtil.HALF_UP;
        }
        if (first == null)
            first = BigDecimal.ZERO;
        if (second == null)
            second = BigDecimal.ZERO;
        if (scale == null)
            scale = 2;
        return first.divide(second, scale, roundingMode);
    }


    /**
     * 金额减法
     *
     * @param first
     * @param second
     * @param roundingMode
     * @param scale
     * @return
     */
    public static BigDecimal subtract(BigDecimal first, BigDecimal second, RoundingMode roundingMode,
                                      Integer scale) {
        if (roundingMode == null) {
            roundingMode = MoneyUtil.HALF_UP;
        }
        if (first == null)
            first = BigDecimal.ZERO;
        if (second == null)
            second = BigDecimal.ZERO;
        if (scale == null)
            scale = 2;
        return (first.subtract(second)).setScale(scale, roundingMode);
    }

    public static BigDecimal subtract(BigDecimal first, BigDecimal second) {
        if (first == null)
            first = BigDecimal.ZERO;
        if (second == null)
            second = BigDecimal.ZERO;
        return first.subtract(second);
    }

    public static BigDecimal add(BigDecimal first, BigDecimal second) {
        if (first == null)
            first = BigDecimal.ZERO;
        if (second == null)
            second = BigDecimal.ZERO;
        return first.add(second);
    }

    /**
     * 金额加法
     *
     * @param first
     * @param second
     * @param roundingMode
     * @param scale
     * @return
     */
    public static BigDecimal add(BigDecimal first, BigDecimal second, RoundingMode roundingMode, Integer scale) {
        if (roundingMode == null) {
            roundingMode = MoneyUtil.HALF_UP;
        }
        if (first == null)
            first = BigDecimal.ZERO;
        if (second == null)
            second = BigDecimal.ZERO;
        if (scale == null)
            scale = 2;
        return (first.add(second)).setScale(scale, roundingMode);
    }


    /**
     * 获取随机的0.01元至配置最高金额的之间的金额
     *
     * @return
     */
    public static BigDecimal randomTransferAmt(BigDecimal maxTransferAmt) {
        return MoneyUtil.divide(
                MoneyUtil.multiply(maxTransferAmt, new BigDecimal(new Random().nextInt(100)), null, null),
                new BigDecimal(100), null, null);
    }


    /**
     * 获取英式金额显示结果
     * <p>
     * 如果 decimal 为整数 则补二位小数.00
     * <p>
     * 如果 decimal 不为整数 则 小数 位原样输出 不格式化小数位
     *
     * @param decimal
     * @return
     */
    public static String EnMoneyFormat(BigDecimal decimal) {
        String str = decimal.toString();
        String prefix = str;
        StringBuffer postfix = new StringBuffer();
        if (str.contains(".")) {
            prefix = str.substring(0, str.indexOf("."));
            postfix.append(str.substring(str.indexOf("."), str.length()));
        } else {
            postfix.append(".00");
        }

        while (postfix.length() < 3) {
            postfix.append("0");
        }

        StringBuffer sb = new StringBuffer();
        int j = 1;
        for (int i = prefix.length() - 1; i >= 0; i--) {
            sb.insert(0, String.valueOf(prefix.charAt(i)));
            if (j % 3 == 0 && j != prefix.length()) {
                sb.insert(0, ",");
            }
            j++;
        }
        return sb.append(postfix).toString();
    }


    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("12");
        System.out.println(subtract(b, new BigDecimal("10.11")));
        System.out.println(add(new BigDecimal("1.89"), new BigDecimal("10.11")));
//        System.out.println(EnMoneyFormat(new BigDecimal("0")));
//        System.out.println(EnMoneyFormat(new BigDecimal("1000")));
//
//        System.out.println(EnMoneyFormat(new BigDecimal("999")));
//        System.out.println(EnMoneyFormat(new BigDecimal("1000.3")));
//        System.out.println(EnMoneyFormat(new BigDecimal("1000.31")));
    }
}
