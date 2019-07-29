package com.bpaas.bps.user.service;

import java.util.Map;

import com.bpaas.bps.common.api.CommonResult;

/**
 * @Author Jason
 * @Date 2019/7/25
 * @Description 密码管理
 * @version 1.0
 */
public interface PwdManagerService {

	public CommonResult<Object> loginPwdMge(Map<String, Object> reqData);
	
	public CommonResult<Object> loginPwdClose(Map<String, Object> reqData);
	
	public Map<String, Object> pwdChecked(Map<String, Object> reqData) throws Exception;
	
	public Map<String, Object> setLoginPwd(Map<String, Object> reqData) throws Exception;
	
}
