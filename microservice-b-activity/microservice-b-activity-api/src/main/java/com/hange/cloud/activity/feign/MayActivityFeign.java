package com.hange.cloud.activity.feign;

import java.util.List;

import com.hange.cloud.activity.api.MayActivityAPI;
import com.hange.cloud.activity.entity.Activity;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-b-activity-server") //名字需要和注册在注册中心的名字一致
public interface MayActivityFeign extends MayActivityAPI {

    public Activity findById(Long id);

    public List<ServiceInstance> showInfo();
}
