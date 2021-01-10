package com.dcy.thread.volatileT.reorder;

/**
 * 目标：测试volatile的可见性
 * 解释：通过volatile类型的标识符来停止另外无法停止的线程
 */
public class Visibility {
    public static volatile long num = 0;

    public static volatile boolean shutDown;

    public static void increase() {
        num++;
    }

    public static void shutDown(){
        shutDown =true;
    }

    private static final int THREAD_NUM = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(() -> {
                int num1 = 0;
                while(!shutDown) {
                    System.out.println(Thread.currentThread().getName()+":"+(num1++));
                }
            });
            threads[i].start();
        }
        Thread.sleep(10000);
        shutDown();
    }
}
