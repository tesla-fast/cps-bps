package com.bpaas.bps.user.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cloudwalk")
public class CloudwalkConfig {

	private String appKey;
	private String appSecret;
	private String charset;
	private String faceCompareUrl;

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getFaceCompareUrl() {
		return faceCompareUrl;
	}

	public void setFaceCompareUrl(String faceCompareUrl) {
		this.faceCompareUrl = faceCompareUrl;
	}

}
