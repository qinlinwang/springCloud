package com.hange.cloud.activity.feign;

import java.util.List;

import com.hange.cloud.activity.api.MayActivityAPI;
import com.hange.cloud.activity.entity.Activity;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "microservice-b-activity-server") //indicate this is a feign
public interface MayActivityFeign extends MayActivityAPI {

    public Activity findById(Long id);

    public List<ServiceInstance> showInfo();
}
