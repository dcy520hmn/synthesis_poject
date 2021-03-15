package com.dcy.dubbo.consumer.controller;

import com.dcy.dubbo.provider.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * dubbo 消费者
 */
@RestController
@RequestMapping("/dubbo")
public class HelloController {

    @DubboReference
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String getName(String name){
        String hello = helloService.sayHello(name);
        System.out.println(hello);
        return hello;
    }
}
