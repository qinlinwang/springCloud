package com.hange.cloud.user.controller;

import com.hange.cloud.user.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //indicate this is a controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    private Registration registration; // 服务注册
    
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/findById", method= RequestMethod.GET )
    public User findById(Long id){
        User findOne = new User("Wanghan", id);
        return findOne;
    }

    @GetMapping("/instance-info")
    public List<ServiceInstance> showInfo() {
        List<ServiceInstance> locaInstances = this.discoveryClient.getInstances(registration.getServiceId());
        return locaInstances;
    }
    
}
