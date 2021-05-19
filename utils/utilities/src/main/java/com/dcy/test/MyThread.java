package com.dcy.test;

/**
 * @author duanchunyu
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月08日 14:47:00
 */
public class MyThread extends Thread{
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    @Override
    public void run() {
        CONTEXT_HOLDER.set("a");
    }
}
