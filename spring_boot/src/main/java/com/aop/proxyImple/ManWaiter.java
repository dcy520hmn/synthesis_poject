package com.aop.proxyImple;

/**
 * Created by Yifan Jia on 2018/6/5.
 */
public class ManWaiter implements Waiter {

    @Override
    public void server() {
        System.out.println("服务中");
    }
}
