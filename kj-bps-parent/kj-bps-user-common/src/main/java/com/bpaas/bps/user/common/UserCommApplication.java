package com.bpaas.bps.user.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.bpaas.bps.user.common.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class UserCommApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCommApplication.class, args);
    }
}
