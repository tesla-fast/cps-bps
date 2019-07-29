//package com.micro.cloud.gateway.config;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//import springfox.documentation.swagger.web.SwaggerResource;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
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
//@Component
//@Primary
//public class DocumentationConfig implements SwaggerResourcesProvider {
//
//    @Override
//    public List<SwaggerResource> get() {
//        List resources = new ArrayList<>();
////        resources.add(swaggerResource("用户微服务接口", "/api/user", "1.0"));
//        resources.add(swaggerResource("支付微服务接口", "/api/pay", "1.0"));
//        return null;
//    }
//
//    private SwaggerResource swaggerResource(String name, String location, String version) {
//        SwaggerResource swaggerResource = new SwaggerResource();
//        swaggerResource.setName(name);
//        swaggerResource.setLocation(location);
//        swaggerResource.setSwaggerVersion(version);
//        return swaggerResource;
//    }
//}
