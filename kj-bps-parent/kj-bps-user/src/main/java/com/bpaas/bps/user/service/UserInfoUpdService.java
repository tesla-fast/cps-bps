package com.bpaas.bps.user.service;

import java.util.Map;

import com.bpaas.bps.common.api.CommonResult;

public interface UserInfoUpdService {

	public CommonResult<Object> infoUpdate(Map<String, Object> reqData);
	
}
