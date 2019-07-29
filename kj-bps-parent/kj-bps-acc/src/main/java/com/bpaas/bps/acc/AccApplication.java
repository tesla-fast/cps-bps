package com.bpaas.bps.acc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.bpaas.bps.acc.mapper")
@EnableFeignClients
public class AccApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccApplication.class, args);
	}
	
}
