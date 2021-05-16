package com.hange.cloud.user.feign;


import java.util.List;

import com.hange.cloud.user.api.UserAPI;
import com.hange.cloud.user.entity.User;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
//1.indicate this is a feign //名字需要和注册在注册中心的名字一致
//2.fallbackFactory 指明降级的类
@FeignClient(name = "microservice-b-user-server", fallbackFactory = UserFeign.UserFeignFallbackFactory.class) 
public interface UserFeign extends UserAPI {
    @Component //这里要添加Component注解，因为否则会找不到这个bean
    class UserFeignFallbackFactory implements FallbackFactory<UserFeign> { //interface里的定义的类自动加static
        @Override
        public UserFeign create(Throwable cause) {
            return new UserFeign() {
                @Override
                public User findById(Long id){
                    return new User("Fallback:"+cause.getMessage(), id);
                }

                @Override
                public List<ServiceInstance> showInfo(){
                    return null;
                }
            
            };
        }
    }

}
