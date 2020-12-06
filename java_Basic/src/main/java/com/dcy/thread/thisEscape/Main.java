package com.dcy.thread.thisEscape;

public class Main {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        ListenerRunnable listenerRunnable = new ListenerRunnable(eventSource);
        new Thread(listenerRunnable).start();
        System.out.println();
        ThisEscape escape = new ThisEscape(eventSource);
        System.out.println(escape);
    }
}