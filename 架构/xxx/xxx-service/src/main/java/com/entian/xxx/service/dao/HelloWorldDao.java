package com.entian.xxx.service.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldDao {

    public String findHello() {
        return "hello";
    }
}
