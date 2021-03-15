package com.dcy.dubbo.provider.service.impl;

import com.dcy.dubbo.provider.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 接口实现类
 */
@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }
}
