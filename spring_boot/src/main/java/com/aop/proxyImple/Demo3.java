package com.aop.proxyImple;

import org.junit.Test;

/**
 * Created by Yifan Jia on 2018/6/5.
 */
public class Demo3 {
    @Test
    public void tset1() {

        ProxyFactory proxyFactory = new ProxyFactory();//创建工厂
        proxyFactory.setTargetObject(new ManWaiter());//设置目标对象
        //设置前置增强
        proxyFactory.setBeforeAdvice(new BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("客户你好");
            }
        });
        //设置后置增强
        proxyFactory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("客户再见");
            }
        });
        Waiter waiter = (Waiter) proxyFactory.creatProxy();
        waiter.server();

    }
}
