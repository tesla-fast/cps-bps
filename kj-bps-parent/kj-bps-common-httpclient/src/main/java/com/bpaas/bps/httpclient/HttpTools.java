package com.bpaas.bps.httpclient;

import com.bpaas.bps.common.utils.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/21
 * @Description: httpclient工具类
 * @version: 1.0
 */
public class HttpTools {

    private final static Logger logger = LoggerFactory.getLogger(HttpTools.class);

    protected static final String HTTPS = "https";

    CloseableHttpClient httpclient = null;

    CloseableHttpResponse httpResponse = null;

    public static String post(String url, Map<String, Object> params, int connectTimeout, int readTimeout) {
        CloseableHttpClient httpclient = null;
        HttpPost httppost = new HttpPost(url);
        try {
            httpclient = HttpClients.createDefault();
            if(params == null || params.size() == 0) {
                return "";
            }

            // 创建参数队列
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            for (String key : params.keySet()) {
                formparams.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(readTimeout)
                    .setConnectTimeout(connectTimeout)
                    .setStaleConnectionCheckEnabled(true)
                    .build();
            httppost.setConfig(requestConfig);
            HttpResponse response = null;
            try {
                response = httpclient.execute(httppost);
            } catch (Exception e) {
                for (int i = 0; i < 2; i++) {
                    try {
                        response = httpclient.execute(httppost);
                        break;
                    } catch (Exception e2) {
                        if(i == 1) {
                            throw e2;
                        } else {
                            continue;
                        }
                    }
                }
            }

            try {
                if(response == null) {
                    return "";
                } else {
                    if(response.getStatusLine().getStatusCode() >= 400) {
                    }
                }
                HttpEntity entity = response.getEntity();
                if(entity != null) {
                    return EntityUtils.toString(entity, "UTF-8");
                }
            } finally {

            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(httppost != null) {
                httppost.releaseConnection();
            }
        }
        return "";
    }

    public static String post(String uri, String jsonStr, int connectTimeout, int readTimeout) {
        CloseableHttpClient httpclient = null;
        HttpPost httppost = new HttpPost(uri);
        try {
            httpclient = HttpClients.createDefault();
            if(jsonStr == null || jsonStr.length() == 0) {
                return "";
            }

            logger.info(JsonUtil.json2xml(jsonStr));
            StringEntity sEntity = new StringEntity(JsonUtil.json2xml(jsonStr),"utf-8");//解决中文乱码问题
            sEntity.setContentEncoding("UTF-8");
            sEntity.setContentType("application/json");
            httppost.setEntity(sEntity);

            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(readTimeout)
                    .setConnectTimeout(connectTimeout)
                    .setStaleConnectionCheckEnabled(true)
                    .build();
            httppost.setConfig(requestConfig);
            HttpResponse response = null;
            try {
                response = httpclient.execute(httppost);
            } catch (Exception e) {
                for (int i = 0; i < 2; i++) {
                    try {
                        response = httpclient.execute(httppost);
                        break;
                    } catch (Exception e2) {
                        if(i == 1) {
                            throw e2;
                        } else {
                            continue;
                        }
                    }
                }
            }

            try {
                if(response == null) {
                    return "";
                } else {
                    if(response.getStatusLine().getStatusCode() >= 400) {
                    }
                }
                HttpEntity entity = response.getEntity();
                if(entity != null) {
                    return EntityUtils.toString(entity, "UTF-8");
                }
            } finally {

            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(httppost != null) {
                httppost.releaseConnection();
            }
        }
        return "";
    }

    protected CloseableHttpClient createHttpclient(String uri) throws Exception {

        CloseableHttpClient chc = null;
        if (uri.indexOf(HTTPS) >= 0) {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf =
                    new SSLConnectionSocketFactory(sslContext,
                            SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            chc = HttpClients.custom().setSSLSocketFactory(sslsf).build();

        } else {
            chc = HttpClients.createDefault();
        }
        return chc;
    }
}
