package com.dcy.thread.thisEscape;

/**
 * 目标：理解什么是this逃逸。
 * 描述：启动两个线程分别A与主线程。
 *      线程A：事件触发
 *      线程Main：对事件增加监听器
 */
public class Main {
    public static void main(String[] args) {
        //设置一个事件源
        EventSource eventSource = new EventSource();
        //启动线程：触发事件
        Task task = new Task(eventSource);
        new Thread(task).start();
        System.out.println();

        //创建逃逸情况：对一个事件增加监听器
        ThisEscape escape = new ThisEscape(eventSource);
        System.out.println(escape);
    }
}