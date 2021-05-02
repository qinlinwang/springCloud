package com.hange.cloud.user.feign;


import com.hange.cloud.user.api.UserAPI;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "microservice-b-user-server") //indicate this is a feign //名字需要和注册在注册中心的名字一致
public interface UserFeign extends UserAPI {

}
