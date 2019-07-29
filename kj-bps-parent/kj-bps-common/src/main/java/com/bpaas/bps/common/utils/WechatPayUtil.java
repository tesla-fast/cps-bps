package com.bpaas.bps.common.utils;

import com.bpaas.bps.common.constants.Constants_comm;
import com.bpaas.bps.common.constants.Constants_wechat;
import com.bpaas.bps.common.constants.Constants_wechat.SignType;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.*;
import java.util.Map.Entry;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 微信支付工具类
 * @version: 1.0
 */
public class WechatPayUtil {

    private WechatPayUtil() {
        super();
    }

    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes(Constants_comm.UTF_8_24));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                /** we were code **/
            }
            return data;
        } catch (Exception ex) {
            WechatPayUtil.getLogger().warn("Invalid XML, can not convert to map. Error message: {/** i am blank **/}. XML content: {/** i am blank **/}", ex.getMessage(), strXML);
            throw ex;
        }

    }
    
    public static String convertMapToXmlTag(final Map<String, String> msgMap, final boolean isUpperKey) {
        String temp = "<xml>";
        if (msgMap != null) {
            final Set<Map.Entry<String, String>> set = msgMap.entrySet();
            for (final Map.Entry<String, String> entry : set) {
                final String key = entry.getKey();
                String value = entry.getValue();
                if (null == value) {
                    value = "";
                }
                if (isUpperKey) {
                    temp = temp + "<" + key.toUpperCase() + ">" + value + "</" + key.toUpperCase() + ">";
                }
                else {
                    temp = temp + "<" + key + ">" + value + "</" + key + ">";
                }
            }
        }
        temp += "</xml>";
        return temp;
    }

    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String mapToXml(Map<String, String> data) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);

        for (Entry<String, String> entry : data.entrySet()) {
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(entry.getKey());
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, Constants_comm.UTF_8_24);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); /** we were code **/
        try {
            writer.close();
        }
        catch (Exception ex) {
        }
        return output;
    }
    
    public static String createSign(final Map<String, String> msg, final String mchKey) throws Exception {
        String temp = "";
        final TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.putAll(msg);
        for (final Map.Entry<String, String> entry : treeMap.entrySet()) {
            if (!StringUtils.isBlank(temp)) {
                if (StringUtils.isBlank((String)entry.getValue())) {
                    continue;
                }
                temp = temp + "&" + entry.getKey() + "=" + entry.getValue();
            }
            else {
                if (StringUtils.isBlank((String)entry.getValue())) {
                    continue;
                }
                temp = entry.getKey() + "=" + entry.getValue();
            }
        }
        return md5(temp + "&key=" + mchKey);
    }

    /**
     * 生成带有 sign 的 XML 格式字符串
     *
     * @param data Map类型数据
     * @param key API密钥
     * @return 含有sign字段的XML
     */
    public static String generateSignedXml(final Map<String, String> data, String key) throws Exception {
        return generateSignedXml(data, key, SignType.MD5);
    }

    /**
     * 生成带有 sign 的 XML 格式字符串
     *
     * @param data Map类型数据
     * @param key API密钥
     * @param signType 签名类型
     * @return 含有sign字段的XML
     */
    public static String generateSignedXml(final Map<String, String> data, String key, SignType signType) throws Exception {
        String sign = generateSignature(data, key, signType);
        data.put(Constants_wechat.FIELD_SIGN, sign);
        return mapToXml(data);
    }


    /**
     * 判断签名是否正确
     *
     * @param xmlStr XML格式数据
     * @param key API密钥
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean isSignatureValid(String xmlStr, String key) throws Exception {
        Map<String, String> data = xmlToMap(xmlStr);
        if (!data.containsKey(Constants_wechat.FIELD_SIGN) ) {
            return false;
        }
        String sign = data.get(Constants_wechat.FIELD_SIGN);
        return generateSignature(data, key).equals(sign);
    }

    /**
     * 判断签名是否正确，必须包含sign字段，否则返回false。使用MD5签名。
     *
     * @param data Map类型数据
     * @param key API密钥
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean isSignatureValid(Map<String, String> data, String key) throws Exception {
        return isSignatureValid(data, key, SignType.MD5);
    }

    /**
     * 判断签名是否正确，必须包含sign字段，否则返回false。
     *
     * @param data Map类型数据
     * @param key API密钥
     * @param signType 签名方式
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean isSignatureValid(Map<String, String> data, String key, SignType signType) throws Exception {
        if (!data.containsKey(Constants_wechat.FIELD_SIGN) ) {
            return false;
        }
        String sign = data.get(Constants_wechat.FIELD_SIGN);
        return generateSignature(data, key, signType).equals(sign);
    }

    /**
     * 生成签名
     *
     * @param data 待签名数据
     * @param key API密钥
     * @return 签名
     */
    public static String generateSignature(final Map<String, String> data, String key) throws Exception {
        return generateSignature(data, key, SignType.MD5);
    }

    /**
     * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
     *
     * @param data 待签名数据
     * @param key API密钥
     * @param signType 签名方式
     * @return 签名
     */
    public static String generateSignature(final Map<String, String> data, String key, SignType signType) throws Exception {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals(Constants_wechat.FIELD_SIGN)) {
                continue;
            }
            if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
        }
        sb.append("key=").append(key);
        if (SignType.MD5.equals(signType)) {
            return md5(sb.toString()).toUpperCase();
        }
        else if (SignType.HMACSHA256.equals(signType)) {
            return hmacsha256(sb.toString(), key);
        }
        else {
            throw new Exception(String.format("Invalid sign_type: %s", signType));
        }
    }


    /**
     * 获取随机字符串 Nonce Str
     *
     * @return String 随机字符串
     */
    public static String generateNonceStr() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, ConstMagicNum.GDCYEEYAMR_111);
    }


    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String md5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes(Constants_comm.UTF_8_24));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, ConstMagicNum.OKZKSIDOTB_92));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 生成 HMACSHA256
     * @param data 待处理数据
     * @param key 密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String hmacsha256(String data, String key) throws Exception {
        Mac sha256HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(Constants_comm.UTF_8_24), "HmacSHA256");
        sha256HMAC.init(secretKey);
        byte[] array = sha256HMAC.doFinal(data.getBytes(Constants_comm.UTF_8_24));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, ConstMagicNum.OKZKSIDOTB_92));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 日志
     * @return
     */
    public static Logger getLogger() {
        return LoggerFactory.getLogger("wxpay java sdk");
    }

    /**
     * 获取当前时间戳，单位秒
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis()/ConstMagicNum.WO_HVBYBR_114;
    }

    /**
     * 获取当前时间戳，单位毫秒
     * @return
     */
    public static long getCurrentTimestampMs() {
        return System.currentTimeMillis();
    }

    /**
     * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, ConstMagicNum.GDCYEEYAMR_111);
    }
}
