package com.hange.cloud.user.entity;


import lombok.Data;

@Data
public class User {

    private Long id;
    
    private String name;

    public User(String name, Long id) {
        this.name = name;
        this.id = id;
    }
    
}
