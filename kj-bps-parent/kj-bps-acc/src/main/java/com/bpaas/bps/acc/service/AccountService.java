package com.bpaas.bps.acc.service;

public interface AccountService<T> {

	public T regOneAccount(T cache) throws Exception;
	
	public T updOneAccount(T cache) throws Exception;
	
	public T integralAcctOpen(T cache) throws Exception;
	
}
