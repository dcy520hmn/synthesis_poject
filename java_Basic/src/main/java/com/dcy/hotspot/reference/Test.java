package com.dcy.hotspot.reference;

public class Test{
    private static int i = 0;

    static {
        if(true){
            System.out.println(Thread.currentThread().getName()+":dead");
            while(true){

            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":start");
                Test test = new Test();
                System.out.println(Thread.currentThread().getName()+":onver");
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

}