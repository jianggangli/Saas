package com.entian.xxx.sdk.auto;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnMissingClass("com.entian.xxx.service.auto.xxxServiceAutoConfiguration")
@EnableFeignClients(basePackages ={"com.entian.xxx.sdk"})
public @interface EnableXxxSdk {

}
