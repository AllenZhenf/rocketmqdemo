package com.demo.rabbitmqdemo;

import java.io.Serializable;

/**
 * @author Allen
 * @create 2018-08-22 上午 9:57
 * @desc 用户
 **/
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
