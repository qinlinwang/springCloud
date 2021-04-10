package com.hange.cloud.eureka;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
* 使用Eureka做服务发现。
* @author wanghan
*/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        //System.out.println("dddd");
        new SpringApplicationBuilder(EurekaApplication.class).web(WebApplicationType.SERVLET).run(args); //fluent builder.
        //SpringApplication.run(EurekaApplication.class, args);
    }
}
