package com.dcy.swt;


/**
 * 事件源中包含监听器。当事件源的某个状态改变，通知监听器去执行对应的回调方法。并且将事件发送给监听器，事件源产生事件。new CusEvent(this)，
 * 事件包含事件源new CusEvent(this)，其中this就是事件源
 * 监听器执行回调函数。
 *
 * 在程序中需要给事件源注册监听器，且回调函数的执行逻辑是什么。
 *
 *
 * https://blog.csdn.net/weixin_30512043/article/details/99446858
 */
public class MainTest {
    public static void main(String[] args) {
        EventSourceObject object = new EventSourceObject();
        //给事件源注册监听器
        object.addCusListener(new CusEventListener() {
            public void fireCusEvent(CusEvent e) {
                EventSourceObject eObject = (EventSourceObject) e.getSource();
                System.out.println("My name has been changed!");
                System.out.println("I got a new name,named \"" + eObject.getName() + "\"");
            }
        });
        // 触发事件
        object.setName("AiLu");
    }
}