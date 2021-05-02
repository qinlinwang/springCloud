package com.hange.cloud.user.controller;

import com.hange.cloud.user.api.UserAPI;
import com.hange.cloud.user.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RestController;

@RestController //indicate this is a controller
public class UserController implements UserAPI{

    @Autowired
    private Registration registration; // 服务注册
    
    @Autowired
    private DiscoveryClient discoveryClient;

    public User findById(Long id){
        User findOne = new User("Wanghan", id);
        return findOne;
    }

    public List<ServiceInstance> showInfo() {
        List<ServiceInstance> locaInstances = this.discoveryClient.getInstances(registration.getServiceId());
        return locaInstances;
    }
    
}
