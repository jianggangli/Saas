package com.entian.xxx.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * xxx-service-版本号xxx-exec.jar：微服务service入口
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class XxxServiceApplication
{
    public static void main(String[] args) {
        SpringApplication.run(XxxServiceApplication.class, args);
    }
}
