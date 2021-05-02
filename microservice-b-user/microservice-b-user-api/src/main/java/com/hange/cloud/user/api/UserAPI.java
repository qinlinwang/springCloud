package com.hange.cloud.user.api;

import java.util.List;

import com.hange.cloud.user.entity.User;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
public interface UserAPI {

    @RequestMapping(value = "/findById", method= RequestMethod.GET )
    public User findById(@RequestParam Long id); // 注意 这里@RequestParam是必须的，具体看这里 https://coding.imooc.com/learn/questiondetail/108882.html

    @GetMapping("/instance-info")
    public List<ServiceInstance> showInfo();
}