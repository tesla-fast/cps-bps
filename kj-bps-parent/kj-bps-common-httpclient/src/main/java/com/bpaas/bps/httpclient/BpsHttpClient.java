package com.bpaas.bps.httpclient;

import java.util.Map;

public interface BpsHttpClient {
	
	public Map<String, Object> doPost(Map<String, Object> map) throws Exception;

	public Map<String, Object> doPost(Map<String, Object> map, String format) throws Exception;
	
	public Map<String, Object> doPostUrl(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> doGet(Map<String, Object> map) throws Exception;
	
}
