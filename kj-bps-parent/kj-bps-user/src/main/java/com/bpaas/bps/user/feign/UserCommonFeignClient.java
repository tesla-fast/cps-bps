package com.bpaas.bps.user.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Jason
 * @Date: 2019/7/26
 * @Description: feign声明式服务
 * @version: 1.0
 */
@FeignClient(name = "kj-bps-user-common")
public interface UserCommonFeignClient {

	@RequestMapping(value = "/whiteInfoQuery", method = RequestMethod.POST)
	public Map<String, Object> whiteInfoQuery(@RequestBody Map<String, Object> reqData) throws Exception;
	
	@RequestMapping(value = "/preLogin", method = RequestMethod.POST)
	public Map<String, Object> preLogin(@RequestBody Map<String, Object> reqData) throws Exception;
	
	@RequestMapping(value = "/regInfoQuery", method = RequestMethod.POST)
	public Map<String, Object> regInfoQuery(@RequestBody Map<String, Object> reqData) throws Exception;
	
	@RequestMapping(value = "/loginSuccSession", method = RequestMethod.POST)
	public Map<String, Object> loginSuccSession(@RequestBody Map<String, Object> reqData) throws Exception;
	
	@RequestMapping(value = "/updateLoginTime", method = RequestMethod.POST)
	public Map<String, Object> updateLoginTime(@RequestBody Map<String, Object> reqData) throws Exception;
	
	@RequestMapping(value = "/loginFailProcessor", method = RequestMethod.POST)
	public Map<String, Object> loginFailProcessor(@RequestBody Map<String, Object> reqData) throws Exception;
    
	@RequestMapping(value = "/baseInfoQuery", method = RequestMethod.POST)
	public Map<String, Object> baseInfoQuery(@RequestBody Map<String, Object> reqData) throws Exception;
	
	@RequestMapping(value = "/faceCompare", method = RequestMethod.POST)
	public Map<String, Object> faceCompare(@RequestBody Map<String, Object> reqData) throws Exception;
	
}
