package com.bpaas.bps.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.user.service.UserLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="用户登录")
@RestController
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	
	/**
     * 功能描述: 用户登录
     * @param: mobile，flag
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/18
     */
	@ApiOperation(value = "用户登录", httpMethod = "POST", notes = "用户登录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "body"),
		@ApiImplicitParam(name = "loginFlag", value = "登录标识", required = true, paramType = "body"),
		@ApiImplicitParam(name = "loginMobile", value = "手机号", required = true, paramType = "body"),
		@ApiImplicitParam(name = "loginPwd", value = "登录密码", required = true, paramType = "body"),
		@ApiImplicitParam(name = "pwdFlag", value = "密码标志", required = true, paramType = "body"),
		@ApiImplicitParam(name = "flag", value = "登录跳转标识", required = true, paramType = "body")
	})
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public CommonResult<Object> userLogin(@RequestBody Map<String, Object> reqData) {
		return userLoginService.pwdLogin(reqData);
	}
	
	@RequestMapping(value = "/faceLogin", method = RequestMethod.POST)
	public CommonResult<Object> faceLogin(@RequestBody Map<String, Object> reqData) {
		return userLoginService.faceLogin(reqData);
	}
	
}
