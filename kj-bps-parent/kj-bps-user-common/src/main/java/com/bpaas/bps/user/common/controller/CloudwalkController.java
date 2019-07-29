package com.bpaas.bps.user.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bpaas.bps.user.common.service.CloudwalkService;

@RestController
public class CloudwalkController {

	@Autowired
	private CloudwalkService<Map<String, Object>> cloudwalkService;
	
	@RequestMapping(value = "/faceCompare", method = RequestMethod.POST)
	public Map<String, Object> faceCompare(@RequestBody Map<String, Object> reqData) throws Exception {
		return cloudwalkService.faceCompare(reqData);
	}
	
}
