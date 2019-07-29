package com.bpaas.bps.user.common.service;

public interface UserCommonService<T> {

	public T whiteInfoQuery(T cache) throws Exception;
	
	public T preLogin(T cache) throws Exception;
	
	public T regInfoQuery(T cache) throws Exception;
	
	public T loginSuccSession(T cache) throws Exception;
	
	public T updateLoginTime(T cache) throws Exception;
	
	public T loginFailProcessor(T cache) throws Exception;
	
	public T baseInfoQuery(T cache) throws Exception;
	
}
