package com.mytest.com.distributedLock;

import org.junit.Test;

public class SaleTicks {

    public static  void main(String[] args) throws InterruptedException {
        TicksOf12306 ticket12306 = new TicksOf12306();
        //�����ͻ���
        Thread t1 = new Thread(ticket12306,"Я��");
        Thread t2 = new Thread(ticket12306,"����");
        t1.start();
        t2.start();
    }

}
