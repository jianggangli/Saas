package com.entian.xxx.web;

import com.entian.xxx.sdk.auto.EnableXxxSdk;
import cn.hutool.core.util.RandomUtil;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * DEMO，启动入口
 */

@EnableXxxSdk
@EnableDiscoveryClient
@SpringBootApplication
public class XxxWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxxWebApplication.class, args);
    }


    @Value("${swagger.group:xxx}")
    private String groupName;

    @Value("${swagger.title:DEMO接口}")
    private String title;

    @Value("${swagger.description:DEMO服务接口文档}")
    private String description;

    @Value("${swagger.creator:504077441@qq.com}")
    private String creator;

    @Value("${swagger.version:4.0.0}")
    private String version;

    @Value("${swagger.package:com.entian.xxx.controller}")
    private String basePackage;


    /**
     * 根据@Tag 上的排序，写入x-order
     *
     * @return the global open api customizer
     */
    @Bean
    public GlobalOpenApiCustomizer orderGlobalOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getTags() != null) {
                openApi.getTags().forEach(tag -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("x-order", RandomUtil.randomInt(0, 100));
                    tag.setExtensions(map);
                });
            }
            if (openApi.getPaths() != null) {
                openApi.addExtension("x-test123", "333");
                openApi.getPaths().addExtension("x-abb", RandomUtil.randomInt(1, 100));
            }

        };
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .contact(new Contact().name(creator).url(creator).email("504077441@qq.com"))
                        .version(version)
                        .description(description)
                        .termsOfService("联系上帝开发对接")
                        .license(new License().name("版权归上帝所有").url(creator))
                )
                ;
    }


}
