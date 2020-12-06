package com.dcy.thread.thisEscape;

import java.util.ArrayList;
import java.util.List;

public class EventSource {

    private final List<AEventListener> eventListeners;

    public EventSource() {
        eventListeners = new ArrayList<>();
    }

    public synchronized void registerListener(AEventListener eventListener)  {
        this.eventListeners.add(eventListener);
        this.notifyAll();
    }

    protected synchronized void notifies() throws InterruptedException {
        if(eventListeners.size() <= 0){
            this.wait();
        }
        for (AEventListener eventListener : eventListeners) {
            eventListener.onEvent(new Object());
        }
    }

    public  void trigger() {
        try {
            this.notifies();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}