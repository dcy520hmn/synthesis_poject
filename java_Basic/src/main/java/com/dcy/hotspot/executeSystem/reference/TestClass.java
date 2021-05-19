package com.dcy.hotspot.reference;

public class TestClass{
    public int calc(){
        int a = 100;
        int b = 200;
        int c = 300;
        System.out.println(a);
        return (a + b) * c;
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.calc();
    }
}
