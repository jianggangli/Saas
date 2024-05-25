package com.entian.xxx.sdk.service;

import com.entian.xxx.IXxxBasicService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import static com.entian.xxx.IXxxBasicService.PREFIX;

@FeignClient(name = "xxx-service", url = "${feign.service.url}", path = PREFIX + "/hello-world")
public interface IHelloWorldService extends IXxxBasicService {

    @PostMapping("/get-string-hello")
    String getStringHello();

}
