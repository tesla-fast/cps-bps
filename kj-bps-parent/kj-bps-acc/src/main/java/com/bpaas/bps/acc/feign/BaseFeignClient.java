package com.bpaas.bps.acc.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/31
 * @Description: feign声明式服务
 * @version: 1.0
 */
@FeignClient(name = "kj-bps-base")
public interface BaseFeignClient {

	@RequestMapping(value = "/generatePotAcctMainNo", method = RequestMethod.POST)
	public String generatePotAcctMainNo();

	@RequestMapping(value = "/generatePotAcctGrowNo", method = RequestMethod.POST)
	public String generatePotAcctGrowNo();

}
