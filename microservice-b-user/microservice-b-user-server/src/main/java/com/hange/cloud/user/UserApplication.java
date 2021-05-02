package com.hange.cloud.user;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户中心
 * 
 * @author wanghan
 */
@SpringBootApplication
@EnableDiscoveryClient // 服务注册到Eureka
@EnableFeignClients(basePackages = {"com.hange.cloud.activity"}) //Scans for interfaces that declare they are feign clients
public class UserApplication {
    public static void main(String[] args) {
        //System.out.println("dddd");
        new SpringApplicationBuilder(UserApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
