package com.dcy.thread.one;

public class MyThread extends Thread {


    @Override
    public void run() {
       int i = 0;
       while(true){
           i++;
           System.out.println(i);
       }
    }


}
