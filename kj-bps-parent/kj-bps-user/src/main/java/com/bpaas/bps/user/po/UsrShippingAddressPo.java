package com.bpaas.bps.user.po;

/**
 * 配送地址
 * @author haowen.wang
 *
 */
public class UsrShippingAddressPo {
	
	/** 主键ID **/
	private int shippingAddressId;
	
	/** 用户ID **/
	private String userId;
	
	/** 收货人姓名 **/
	private String shippingUserName;
	
	/** 联系电话 **/
	private String contactMobile;
	
	/** 实际配送地址 **/
	private String address;
	
	/** 城市 **/
	private String city;
	
	/** 区/县 **/
	private String state;
	
	/** 邮编 **/
	private String zipcode;
	
	/** 国家 **/
	private String country;
	
	/** 地址默认标志 **/
	private String defaultFlag;

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShippingUserName() {
		return shippingUserName;
	}

	public void setShippingUserName(String shippingUserName) {
		this.shippingUserName = shippingUserName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

}
