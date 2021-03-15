package com.dcy.hotspot.memoryManager.outOfMempry;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String st1 = new StringBuffer().append("j").append("ava").toString();
        System.out.println(st1.intern()==st1);
    }
}
