package com.bpaas.bps.user.common.service;

public interface CcintService<T> {

	public T recognizeIdCard(T cache) throws Exception;
	
	public T recognizeBankCard(T cache) throws Exception;
	
}
