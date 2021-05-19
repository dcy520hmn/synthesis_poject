package com.dcy.test;

import java.lang.reflect.Field;

public class ThreadLocalTest {

    public static void main(String[] args) {
        printAllSlot(8);
        printAllSlot(16);
        printAllSlot(32);
    }

    static void printAllSlot(int len) {
        System.out.println("********** len = " + len + " ************");
        for (int i = 1; i <= 32; i++) {
            ThreadLocal<String> t = new ThreadLocal<>();
            int slot = getSlot(t, len);
            if (i % len == 0)
                System.out.println(); // 分组换行
        }
    }

    /**
     * 获取槽位
     * 
     * @param t ThreadLocal
     * @param len 模拟map的table的length
     * @throws Exception
     */
    static int getSlot(ThreadLocal<?> t, int len) {
        int hash = getHashCode(t);
        int solt = hash & (len - 1);
        System.out.print(solt + " ");
        return solt;
    }

    /**
     * 反射获取 threadLocalHashCode 字段，因为其为private的
     */
    static int getHashCode(ThreadLocal<?> t) {
        Field field;
        try {
            field = t.getClass().getDeclaredField("threadLocalHashCode");
            field.setAccessible(true);
            return (int) field.get(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}