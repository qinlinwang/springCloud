package com.hange.cloud.activity.api;

import java.util.List;

import com.hange.cloud.activity.entity.Activity;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/mayactivity")
public interface MayActivityAPI {

    @RequestMapping(value = "/findById", method= RequestMethod.GET )
    public Activity findById(Long id);

    @GetMapping("/instance-info")
    public List<ServiceInstance> showInfo();
}