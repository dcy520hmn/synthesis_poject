package com.mytest.com.distributedLock;

import org.junit.Test;

public class SaleTicks {

    public static  void main(String[] args) throws InterruptedException {
        TicksOf12306 ticket12306 = new TicksOf12306();
        //创建客户端
        Thread t1 = new Thread(ticket12306,"携程");
        Thread t2 = new Thread(ticket12306,"飞猪");
        t1.start();
        t2.start();
    }

}
