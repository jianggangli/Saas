package com.entian.xxx.web.controller;

import com.entian.xxx.web.logic.HelloWorldLogic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 以结尾xxxController，编写与前端交互的数据的适配
 * 例如，前端获取带人民币￥的显示这里就进行数据的适配
 */
@RestController
@Tag(name = "Api例子")
public class HelloWorldController {

    @Autowired
    private HelloWorldLogic helloWorldLogic;

    @GetMapping("/hello")
    @Operation(summary = "获取hello")
    public String hello() {
        return helloWorldLogic.print();
    }
}
