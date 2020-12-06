package com.dcy.thread;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadTest {
    public void t(){
        System.out.println("out");
    }
    class Inner{
        public void t(){
            System.out.println("inner");
        }

        public void test(){
            this.t();
            ThreadTest.this.t();
        }
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Inner inner = threadTest.new Inner();
        inner.test();
    }
}
