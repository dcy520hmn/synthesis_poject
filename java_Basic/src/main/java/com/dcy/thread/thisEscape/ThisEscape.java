package com.dcy.thread.thisEscape;

import java.util.concurrent.TimeUnit;

/**
 * 描述：对一个事件，增加监听器。
 */
public class ThisEscape {
    public final int id;
    public final String name;
    public ThisEscape(EventSource eventSource) {
        id = 1;
        //注册监听器
        eventSource.registerListener(
        	new AEventListener() {//匿名内部类可以访问外部的this对象。此时外部的this对象还没有初始化完成就已发布出去。
            @Override
            public void onEvent(Object object) {
                System.out.println("id:" + ThisEscape.this.id);
                //此时name可能还没有被初始化，this就被发布出去
                System.out.println("name:" + ThisEscape.this.name);
            }
           
        });
        //间隔
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