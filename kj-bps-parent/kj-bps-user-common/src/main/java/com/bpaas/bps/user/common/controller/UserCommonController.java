package com.bpaas.bps.user.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bpaas.bps.user.common.service.UserCommonService;

@RestController
public class UserCommonController {

	@Autowired
	private UserCommonService<Map<String, Object>> userCommonService;
	
	@RequestMapping(value = "/whiteInfoQuery", method = RequestMethod.POST)
	public Map<String, Object> whiteInfoQuery(@RequestBody Map<String, Object> reqData) throws Exception {
		return userCommonService.whiteInfoQuery(reqData);
	}
	
	@RequestMapping(value = "/preLogin", method = RequestMethod.POST)
	public Map<String, Object> preLogin(@RequestBody Map<String, Object> reqData) throws Exception {
		return userCommonService.preLogin(reqData);
	}
	
	@RequestMapping(value = "/regInfoQuery", method = RequestMethod.POST)
	public Map<String, Object> regInfoQuery(@RequestBody Map<String, Object> reqData) throws Exception {
		return userCommonService.regInfoQuery(reqData);
	}
	
	@RequestMapping(value = "/loginSuccSession", method = RequestMethod.POST)
	public Map<String, Object> loginSuccSession(@RequestBody Map<String, Object> reqData) throws Exception {
		return userCommonService.loginSuccSession(reqData);
	}
	
	@RequestMapping(value = "/updateLoginTime", method = RequestMethod.POST)
	public Map<String, Object> updateLoginTime(@RequestBody Map<String, Object> reqData) throws Exception {
		return userCommonService.updateLoginTime(reqData);
	}
	
	@RequestMapping(value = "/loginFailProcessor", method = RequestMethod.POST)
	public Map<String, Object> loginFailProcessor(@RequestBody Map<String, Object> reqData) throws Exception {
		return userCommonService.loginFailProcessor(reqData);
	}
	
	@RequestMapping(value = "/baseInfoQuery", method = RequestMethod.POST)
	public Map<String, Object> baseInfoQuery(@RequestBody Map<String, Object> reqData) throws Exception {
		return userCommonService.baseInfoQuery(reqData);
	}
	
}
