package com.springboot.service.impl;

import com.springboot.config.aspect.LogAspect;
import org.springframework.stereotype.Service;

/**
 * 该类的所有方法都是连接点
 */
@Service
@LogAspect
public class AccountService {

    @LogAspect
    public void transfer(){
        System.out.println("A:-1000");
        System.out.println("B:+1000");
    }

    public void transfer1(){
        System.out.println("A:-2000");
        System.out.println("B:+2000");
    }
}
