package com.bpaas.bps.user.service;

import java.util.Map;

import com.bpaas.bps.common.api.CommonResult;

/**
 * @Author Jason
 * @Date 2019/7/23
 * @Description 用户注册
 * @version 1.0
 */
public interface UserRegService {

	/**
	 * 注册检查
	 * @param reqData
	 * @return 返回检查结果
	 */
	public CommonResult<Object> regCheck(Map<String, Object> reqData);
	
	/**
	 * 用户注册
	 * @param reqData
	 * @return 返回注册结果
	 */
	public CommonResult<Object> regInfoRecord(Map<String, Object> reqData);
	
	
}
