package com.bpaas.bps.acc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bpaas.bps.acc.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService<Map<String, Object>> accountService;

	@RequestMapping(value = "/regOneAccount", method = RequestMethod.POST)
	public Map<String, Object> regOneAccount(@RequestBody Map<String, Object> reqData) throws Exception {
		return accountService.regOneAccount(reqData);
	}
	
	@RequestMapping(value = "/updOneAccount", method = RequestMethod.POST)
	public Map<String, Object> updOneAccount(@RequestBody Map<String, Object> reqData) throws Exception {
		return accountService.updOneAccount(reqData);
	}
	
	@RequestMapping(value = "/integralAcctOpen", method = RequestMethod.POST)
	public Map<String, Object> integralAcctOpen(@RequestBody Map<String, Object> reqData) throws Exception {
		return accountService.integralAcctOpen(reqData);
	}
	
}
