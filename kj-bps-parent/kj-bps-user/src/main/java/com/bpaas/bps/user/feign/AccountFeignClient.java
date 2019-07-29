package com.bpaas.bps.user.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Jason
 * @Date: 2019/7/17
 * @Description: feign声明式服务
 * @version: 1.0
 */
@FeignClient(name = "kj-bps-acc")
public interface AccountFeignClient {

	@RequestMapping(value = "/regOneAccount", method = RequestMethod.POST)
	public Map<String, Object> regOneAccount(@RequestBody Map<String, Object> reqData) throws Exception;

	@RequestMapping(value = "/updOneAccount", method = RequestMethod.POST)
	public Map<String, Object> updOneAccount(@RequestBody Map<String, Object> reqData) throws Exception;
	
	@RequestMapping(value = "/integralAcctOpen", method = RequestMethod.POST)
	public Map<String, Object> integralAcctOpen(@RequestBody Map<String, Object> reqData) throws Exception;
    
}
