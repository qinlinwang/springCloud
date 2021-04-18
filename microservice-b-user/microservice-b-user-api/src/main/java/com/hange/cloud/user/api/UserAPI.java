package com.hange.cloud.user.api;

import java.util.List;

import com.hange.cloud.user.entity.User;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
public interface UserAPI {

    @RequestMapping(value = "/findById", method= RequestMethod.GET )
    public User findById(Long id);

    @GetMapping("/instance-info")
    public List<ServiceInstance> showInfo();
}