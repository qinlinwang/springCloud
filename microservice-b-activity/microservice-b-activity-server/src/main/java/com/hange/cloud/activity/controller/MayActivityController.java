package com.hange.cloud.activity.controller;

import com.hange.cloud.activity.entity.Activity;
import com.hange.cloud.user.entity.User;
import com.hange.cloud.user.feign.UserFeign;

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
public class MayActivityController {

    @Autowired
    private Registration registration; // 服务注册
    
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeign userFeign;

    @RequestMapping(value = "/findById", method= RequestMethod.GET )
    public Activity findById(Long id){
        User user = this.userFeign.findById(id);
        Activity findOne = new Activity(user.getName(), user.getId()+1);
        return findOne;
    }

    @GetMapping("/instance-info")
    public List<ServiceInstance> showInfo() {
        List<ServiceInstance> locaInstances = this.discoveryClient.getInstances(registration.getServiceId());
        return locaInstances;
    }
    
}
