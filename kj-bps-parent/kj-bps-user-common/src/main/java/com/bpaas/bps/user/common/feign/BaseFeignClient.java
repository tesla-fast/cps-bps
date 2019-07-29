package com.bpaas.bps.user.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Jason
 * @Date: 2019/7/25
 * @Description: feign声明式服务
 * @version: 1.0
 */
@FeignClient(name = "kj-bps-base")
public interface BaseFeignClient {

    @RequestMapping(value = "/generateUserId", method = RequestMethod.POST)
    public String generateUserId();

    @RequestMapping(value = "/decryPwd", method = RequestMethod.POST)
    public String decryPwd(String pwd);
    
    @RequestMapping(value = "/getParmValue", method = RequestMethod.POST)
    public String getParmValue(@RequestBody String parmId);
    
}
