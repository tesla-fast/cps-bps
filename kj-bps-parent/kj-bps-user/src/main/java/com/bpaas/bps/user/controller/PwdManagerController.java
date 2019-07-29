package com.bpaas.bps.user.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.user.service.PwdManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="密码管理")
@RestController
public class PwdManagerController {

	private PwdManagerService pwdManagerService;
	
	/**
     * 功能描述: 登录密码-忘记或修改
     * @param: mobile，flag
     * @return: JSONObject
     * @author: Jason
     * @date: 2019/07/24
     */
	@ApiOperation(value = "忘记密码和修改密码", httpMethod = "POST", notes = "忘记密码和修改密码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户ID和手机号码，客观判断，可选择其中一个，即可", required = true, paramType = "body"),
		@ApiImplicitParam(name = "mobile", value = "用户ID和手机号码，客观判断，可选择其中一个，即可", required = true, paramType = "body"),
		@ApiImplicitParam(name = "operFlag", value = "操作标志", required = true, paramType = "body"),
		@ApiImplicitParam(name = "hisPwd", value = "原密码", required = true, paramType = "body"),
		@ApiImplicitParam(name = "setPwd", value = "新密码", required = true, paramType = "body")
	})
	@RequestMapping(value = "/loginPwdMge", method = RequestMethod.POST)
	public CommonResult<Object> loginPwdMge(@RequestBody Map<String, Object> reqData) {
		/*非空检查*/
		
		return pwdManagerService.loginPwdMge(reqData);
	}
	
	/**
	 * 登录密码-关闭
	 * @param reqData
	 * @return
	 */
	@ApiOperation(value = "登录密码-关闭", httpMethod = "POST", notes = "登录密码-关闭")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "body"),
		@ApiImplicitParam(name = "pwdFlag", value = "密码标识", required = true, paramType = "body"),
		@ApiImplicitParam(name = "openFlag", value = "开启标志", required = true, paramType = "body")
	})
	@RequestMapping(value = "/pwdManager", method = RequestMethod.POST)
	public CommonResult<Object> pwdManager(@RequestBody Map<String, Object> reqData) {
		/*非空检查*/
		return pwdManagerService.loginPwdClose(reqData);
	}
	
}
