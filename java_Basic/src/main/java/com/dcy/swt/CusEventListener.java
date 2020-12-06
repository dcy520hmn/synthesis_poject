package com.dcy.swt;

import java.util.EventListener;

/**
 * 事件监听器，实现java.util.EventListener接口。定义回调方法，将你想要做的事放到这个方法下,因为事件源发生相应的事件时会调用这个方法。
 */
public interface CusEventListener extends EventListener {
    // 事件发生后的回调方法
    void fireCusEvent(CusEvent e);
}