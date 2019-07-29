package com.bpaas.bps.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/21
 * @Description:
 * @version: 1.0
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.bpaas.bps.pay.mapper")
@EnableDiscoveryClient
@EnableSwagger2
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
