package com.dcy.thread.thisEscape;


/**
 * 描述：用来触发监听器。
 */
public class Task implements Runnable {
    private EventSource source;

    public Task(EventSource source) {
        this.source = source;
    }

    @Override
    public void run() {
        source.trigger();
    }
}