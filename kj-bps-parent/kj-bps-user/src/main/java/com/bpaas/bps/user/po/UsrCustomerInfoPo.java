package com.bpaas.bps.user.po;

/**
 * 客户信息
 * @author haowen.wang
 *
 */
public class UsrCustomerInfoPo {

	/** 主键ID **/
	private int customerId;
	
	/** 姓 **/
	private String firstName;
	
	/** 名 **/
	private String lastName;
	
	/** 手机号码 **/
	private String customerPhone;
	
	/** 收货地址ID **/
	private int shippingAddressId;
	
	/** 用户ID **/
	private String uId;
	
//	private int cartId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

//	public int getCartId() {
//		return cartId;
//	}
//
//	public void setCartId(int cartId) {
//		this.cartId = cartId;
//	}

}
