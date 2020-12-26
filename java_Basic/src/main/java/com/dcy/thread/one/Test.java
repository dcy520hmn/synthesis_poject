package com.dcy.thread.one;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        User user = new User();

        Thread thread1 = new Thread(() -> {
            user.setName("xiaoming");
            user.setPass("12");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(user.getName());
            System.out.println(user.getPass());
        });

        thread1.start();
        thread2.start();
    }
}
