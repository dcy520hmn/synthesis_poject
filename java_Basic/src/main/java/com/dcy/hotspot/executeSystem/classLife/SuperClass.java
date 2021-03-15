package com.dcy.hotspot.executeSystem.classLife;

public class SuperClass {

    static {
        System.out.println("initSuper");
    }

    public SuperClass() {
        System.out.println("superConst");
    }

    public static String hello="hello";
}
