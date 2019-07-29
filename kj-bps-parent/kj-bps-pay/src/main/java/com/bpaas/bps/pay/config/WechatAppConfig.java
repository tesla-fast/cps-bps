package com.bpaas.bps.pay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Jason
 * @Date: 2019/07/04
 * @Description:
 * @version: 1.0
 */
@Component
@ConfigurationProperties(prefix="wechat-app")
public class WechatAppConfig {
	
	private String serverUrl;
	private String appId;
	private String mchId;
	private String mchKey;
	private String signtype;
	private String unifiedorder;
	private String orderquery;
	private String downloadbill;
	private String getsignkey;
	private String downloadurl;
	private String notifyUrl;
	
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getMchKey() {
		return mchKey;
	}
	public void setMchKey(String mchKey) {
		this.mchKey = mchKey;
	}
	public String getSigntype() {
		return signtype;
	}
	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}
	public String getUnifiedorder() {
		return unifiedorder;
	}
	public void setUnifiedorder(String unifiedorder) {
		this.unifiedorder = unifiedorder;
	}
	public String getOrderquery() {
		return orderquery;
	}
	public void setOrderquery(String orderquery) {
		this.orderquery = orderquery;
	}
	public String getDownloadbill() {
		return downloadbill;
	}
	public void setDownloadbill(String downloadbill) {
		this.downloadbill = downloadbill;
	}
	public String getGetsignkey() {
		return getsignkey;
	}
	public void setGetsignkey(String getsignkey) {
		this.getsignkey = getsignkey;
	}
	public String getDownloadurl() {
		return downloadurl;
	}
	public void setDownloadurl(String downloadurl) {
		this.downloadurl = downloadurl;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
}
