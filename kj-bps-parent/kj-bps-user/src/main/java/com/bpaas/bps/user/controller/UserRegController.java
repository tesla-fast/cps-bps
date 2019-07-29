package com.bpaas.bps.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.user.service.UserRegService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @Author: Jason
 * @Date: 2019/07/18
 * @Description:
 * @version: 1.0
 */
@Api(tags="用户注册")
@RestController
public class UserRegController {

	@Autowired
	private UserRegService userRegService;
	
	/**
     * 功能描述: 用户注册检查
     * @param: mobile，flag
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/18
     */
	@ApiOperation(value = "用户注册检查", httpMethod = "POST", notes = "用户注册检查")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "mobile", value = "手机号码", required = true, paramType = "body")
	})
	@RequestMapping(value = "/regCheck", method = RequestMethod.POST)
	public CommonResult<Object> regCheck(@RequestBody Map<String, Object> reqData) {
		return userRegService.regCheck(reqData);
	}
	
	/**
     * 功能描述: 用户注册
     * @param: loginFlag，mobile
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/18
     */
	@ApiOperation(value = "用户注册", httpMethod = "POST", notes = "用户注册")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "loginFlag", value = "登录标识", required = true, paramType = "body"),
		@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "body")
	})
	@RequestMapping(value = "/regInfoRecord", method = RequestMethod.POST)
	public CommonResult<Object> regInfoRecord(@RequestBody Map<String, Object> reqData) {
		return userRegService.regInfoRecord(reqData);
	}
	
}
