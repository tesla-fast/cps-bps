package com.bpaas.bps.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bpaas.bps.common.api.CommonResult;
import com.bpaas.bps.user.service.UserInfoUpdService;

@RestController
public class UserInfoUpdController {

	@Autowired
	private UserInfoUpdService userInfoUpdService;
	
	@RequestMapping(value = "/infoUpdate", method = RequestMethod.POST)
	public CommonResult<Object> infoUpdate(@RequestBody Map<String, Object> reqData) {
		return userInfoUpdService.infoUpdate(reqData);
	}
	
}