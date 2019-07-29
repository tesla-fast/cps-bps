package com.bpaas.bps.user.common.service;

public interface UserOtherService<T> {

	public T bbmService(T cache);
	
	public T kycIdentify(T cache);
	
}
