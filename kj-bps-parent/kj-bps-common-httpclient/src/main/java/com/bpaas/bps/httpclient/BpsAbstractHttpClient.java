package com.bpaas.bps.httpclient;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public abstract class BpsAbstractHttpClient implements BpsHttpClient {
	protected static final int OK = 200;
	protected static final String HTTPS = "https";
	private String serverUrl;
	private String charset = "utf-8";
	private int connectTimeout = 3000;
	private int readTimeout = 15000;
	private String format = "json";

	public BpsAbstractHttpClient(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public BpsAbstractHttpClient(String serverUrl, String charset) {
		this.serverUrl = serverUrl;
		this.charset = charset;
	}

	public BpsAbstractHttpClient(String serverUrl, String charset, String format) {
		this.serverUrl = serverUrl;
		this.charset = charset;
		this.format = format;
	}

	public BpsAbstractHttpClient(String serverUrl, String charset, int connectTimeout, int readTimeout) {
		this.serverUrl = serverUrl;
		this.charset = charset;
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
	}

	public BpsAbstractHttpClient(String serverUrl, String charset, int connectTimeout, int readTimeout, String format) {
		this.serverUrl = serverUrl;
		this.charset = charset;
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
		this.format = format;
	}

	@Override
	public Map<String, Object> doPost(Map<String, Object> map) throws Exception {
		return doPost(map, format);
	}

	@Override
	public Map<String, Object> doPost(Map<String, Object> map, String format) throws Exception {
		Map<String, Object> rspMap = new HashMap<String, Object>();
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		try {
			URIBuilder uriBuilder = new URIBuilder(serverUrl);
			httpclient = createHttpclient(uriBuilder.build().toString());
			HttpPost httppost = new HttpPost(serverUrl);
			if ("form".equals(format)) {
				// 创建参数队列
				List<NameValuePair> formparams = new ArrayList<NameValuePair>();
				Set<Entry<String, Object>> entrySet = map.entrySet();
				for (Entry<String, Object> entry : entrySet) {
					formparams.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
				}
				UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, charset);
				httppost.setEntity(uefEntity);
			} else if ("json".equals(format)) {
				httppost.setHeader("Content-Type", "application/json;charset=" + charset);
				StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(map));
				httppost.setEntity(stringEntity);

			}
			// 设置请求和传输超时时间
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(readTimeout)
					.setConnectTimeout(connectTimeout).build();
			httppost.setConfig(requestConfig);
			response = httpclient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();
			rspMap.put("statusCode", statusCode);
			rspMap.put("rspBody", EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			rspMap.put("statusCode", "999");
			rspMap.put("errorMsg", "请求第三方超时");
		} finally {
			if (null != response) {
				response.close();
			}
			if (null != httpclient) {
				httpclient.close();
			}
		}
		return rspMap;
	}

	@Override
	public Map<String, Object> doPostUrl(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> doGet(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	protected CloseableHttpClient createHttpclient(String uri) throws Exception {
		CloseableHttpClient chc = null;
		if (uri.indexOf(HTTPS) >= 0) {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			chc = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} else {
			chc = HttpClients.createDefault();
		}
		return chc;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
