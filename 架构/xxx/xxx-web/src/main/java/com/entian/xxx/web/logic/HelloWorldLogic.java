package com.entian.xxx.web.logic;

import com.entian.xxx.sdk.service.IHelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 以结尾xxxLogic，编写来源于service的业务逻辑运算
 * 例如，前端同时获取某个员工一周考勤数据+员工考勤是否正常
 *      1.获取一周考勤数据记录，
 *      2.计算考勤是否正常并设置VO属性
 */
@Component
public class HelloWorldLogic {

    @Autowired
    private IHelloWorldService helloWorldService;

    public String print() {
        return helloWorldService.getStringHello();
//        return "hello";
    }
}
