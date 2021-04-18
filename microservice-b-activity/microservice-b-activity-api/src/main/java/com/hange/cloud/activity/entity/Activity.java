package com.hange.cloud.activity.entity;


import lombok.Data;

@Data
public class Activity {

    private Long id;
    
    private String name;

    public Activity(String name, Long id) {
        this.name = name;
        this.id = id;
    }
    
}
