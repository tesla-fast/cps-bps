//package com.micro.cloud.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.ParameterBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Parameter;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: haowen.wang
// * @Date: 2019/5/28
// * @Description:
// * @version: 1.0
// */
//@Configuration
//public class Swagger2Config {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.bpaas.bps"))
//                .paths(PathSelectors.any())
//                .build()
//                .globalOperationParameters(parameters());
//
//    }
//
//    public ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("业务中台API文档")
//                .description("restful风格")
//                .termsOfServiceUrl("") //服务条款网址
//                .contact("kj-bps")
//                .version("1.0")
//                .build();
//    }
//
//    private List<Parameter> parameters() {
//        ParameterBuilder parameterBuilder = new ParameterBuilder();
//        List<Parameter> parameters = new ArrayList<>();
//        parameterBuilder.name("Authorization")
//                .description("Authorization")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false).build();
//        parameters.add(parameterBuilder.build());
//        return parameters;
//    }
//}
