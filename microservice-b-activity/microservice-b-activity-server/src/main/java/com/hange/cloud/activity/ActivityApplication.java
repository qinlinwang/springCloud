package com.hange.cloud.activity;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户中心
 * 
 * @author wanghan
 */
@SpringBootApplication(scanBasePackages={"com.hange.cloud.activity","com.hange.cloud.user.feign"}) //这里添加对com.hange.cloud.activity的扫描
@EnableDiscoveryClient // 服务注册到Eureka
@EnableFeignClients(basePackages = {"com.hange.cloud.user.feign"}) //Scans for interfaces that declare they are feign clients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ActivityApplication {
    public static void main(String[] args) {
        //System.out.println("dddd");
        new SpringApplicationBuilder(ActivityApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
