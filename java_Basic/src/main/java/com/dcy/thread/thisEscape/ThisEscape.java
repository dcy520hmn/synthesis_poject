package com.dcy.thread.thisEscape;

import java.util.concurrent.TimeUnit;

public class ThisEscape {
    public final int id;
    public final String name;
    public ThisEscape(EventSource eventSource) {
        id = 1;
        eventSource.registerListener(
        	new AEventListener() {
            @Override
            public void onEvent(Object object) {
                System.out.println("id:" + ThisEscape.this.id);
                System.out.println("name:" + ThisEscape.this.name);
            }
           
        });
        try {
            TimeUnit.SECONDS.sleep(1);//此处加入相关断点。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "thisEscape test.";
    }

    @Override
    public String toString() {
        return "ThisEscape{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}