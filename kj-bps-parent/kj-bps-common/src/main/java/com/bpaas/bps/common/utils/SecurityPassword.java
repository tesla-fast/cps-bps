package com.bpaas.bps.common.utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 密码工具类
 * @version: 1.0
 */
public class SecurityPassword {

    public static String decryPassword(String password) {
        String salt = genSalt();
        password = sha256Hex(password + salt);
        return confuse(password, salt);
    }

    /**
     * 加盐
     *
     * @return
     */
    private static String genSalt() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /**
     * 加密
     *
     * @param src
     * @return
     */
    private static String sha256Hex(String src) {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] bs = sha256.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 隐藏盐
     *
     * @param password
     * @param salt
     * @return
     */
    private static String confuse(String password, String salt) {
        char[] cs = new char[80];
        for (int i = 0; i < 80; i += 5) {
            cs[i] = password.charAt(i / 5 * 4);
            char c = salt.charAt(i / 5);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 5 * 4 + 1);
            cs[i + 3] = password.charAt(i / 5 * 4 + 2);
            cs[i + 4] = password.charAt(i / 5 * 4 + 3);
        }
        return new String(cs);
    }
    
    /**
	 * 验证
	 * 
	 * @param password
	 * @param sha256
	 * @return
	 */
	public static boolean verify(String password, String sha256) {
		char[] cs1 = new char[64];
		char[] cs2 = new char[16];
		for (int i = 0; i < 80; i += 5) {
			cs1[i / 5 * 4] = sha256.charAt(i);
			cs1[i / 5 * 4 + 1] = sha256.charAt(i + 2);
			cs1[i / 5 * 4 + 2] = sha256.charAt(i + 3);
			cs1[i / 5 * 4 + 3] = sha256.charAt(i + 4);
			cs2[i / 5] = sha256.charAt(i + 1);
		}
		String salt = new String(cs2);
		return sha256Hex(password + salt).equals(new String(cs1));
	}
}
