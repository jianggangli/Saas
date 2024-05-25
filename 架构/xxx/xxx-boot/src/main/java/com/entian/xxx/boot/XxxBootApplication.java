package com.entian.xxx.boot;

import com.entian.xxx.starter.auto.EnableEnTianXxx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DEMO，启动入口
 */
@EnableEnTianXxx
@SpringBootApplication
public class XxxBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxxBootApplication.class, args);
    }



}
