package com.dcy.thread.thisEscape;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *  该事件源中存在多个监听器，对事件进行监听。
 */
public class EventSource {

    private final List<AEventListener> eventListeners;

    public EventSource() {
        eventListeners = new ArrayList<>();
    }

    public synchronized void registerListener(AEventListener eventListener)  {
        this.eventListeners.add(eventListener);
        this.notifyAll();
    }

    /**
     * 触发监听器之后，监听器要做的事情
     * @throws InterruptedException
     */
    protected synchronized void notifies() throws InterruptedException {
        if(eventListeners.size() <= 0){
            this.wait();
        }
        for (AEventListener eventListener : eventListeners) {
            eventListener.onEvent(new Object());
        }
    }

    /**
     * 触发监听器
     */
    public  void trigger() {
        try {
            this.notifies();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}