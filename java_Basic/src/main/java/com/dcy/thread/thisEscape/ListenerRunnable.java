package com.dcy.thread.thisEscape;


public class ListenerRunnable implements Runnable {
    private EventSource source;

    public ListenerRunnable(EventSource source) {
        this.source = source;
    }

    @Override
    public void run() {
        source.trigger();
    }
}