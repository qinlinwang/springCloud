package com.hange.cloud.user;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户中心
 * 
 * @author wanghan
 */
@SpringBootApplication
@EnableDiscoveryClient // 服务注册到Eureka
public class UserApplication {
    public static void main(String[] args) {
        //System.out.println("dddd");
        new SpringApplicationBuilder(UserApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
