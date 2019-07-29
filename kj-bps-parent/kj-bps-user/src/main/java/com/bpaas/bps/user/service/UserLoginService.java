package com.bpaas.bps.user.service;

import java.util.Map;

import com.bpaas.bps.common.api.CommonResult;

/**
 * @Author Jason
 * @Date 2019/7/25
 * @Description 用户登录
 * @version 1.0
 */
public interface UserLoginService {

	public CommonResult<Object> pwdLogin(Map<String, Object> reqData);
	
	public CommonResult<Object> faceLogin(Map<String, Object> reqData);
	
}
