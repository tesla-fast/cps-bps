package com.bpaas.bps.httpclient;

public class BpsDefaultHttpClient extends BpsAbstractHttpClient {

	public BpsDefaultHttpClient(String serverUrl, String charset, int connectTimeout, int readTimeout, String format) {
		super(serverUrl, charset, connectTimeout, readTimeout, format);
	}

	public BpsDefaultHttpClient(String serverUrl, String charset, int connectTimeout, int readTimeout) {
		super(serverUrl, charset, connectTimeout, readTimeout);
	}

	public BpsDefaultHttpClient(String serverUrl, String charset, String format) {
		super(serverUrl, charset, format);
	}

	public BpsDefaultHttpClient(String serverUrl, String charset) {
		super(serverUrl, charset);
	}

	public BpsDefaultHttpClient(String serverUrl) {
		super(serverUrl);
	}

}
