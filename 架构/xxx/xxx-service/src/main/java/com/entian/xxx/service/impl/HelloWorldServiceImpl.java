package com.entian.xxx.service.impl;

import com.entian.xxx.sdk.service.IHelloWorldService;
import com.entian.xxx.service.dao.HelloWorldDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.entian.xxx.IXxxBasicService.PREFIX;

@Service
@RestController
@RequestMapping(PREFIX + "/hello-world")
public class HelloWorldServiceImpl implements IHelloWorldService {

    @Autowired
    private HelloWorldDao helloWorldDao;

    @PostMapping("/get-string-hello")
    public String getStringHello() {
        return helloWorldDao.findHello();
    }

}
