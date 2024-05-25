package com.entian.xxx.starter.auto;


import com.entian.xxx.service.auto.XxxServiceAutoConfiguration;
import com.entian.xxx.web.auto.XxxWebAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan(basePackages = {"com.entian.xxx.web", "com.entian.xxx.service"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {XxxWebAutoConfiguration.class, XxxServiceAutoConfiguration.class})
        })
public @interface EnableEnTianXxx {

}
