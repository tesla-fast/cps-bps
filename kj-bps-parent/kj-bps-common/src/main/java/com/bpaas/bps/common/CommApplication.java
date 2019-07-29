package com.bpaas.bps.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description:
 * @version: 1.0
 */
@SpringBootApplication
@EnableSwagger2
public class CommApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommApplication.class, args);
    }
}
