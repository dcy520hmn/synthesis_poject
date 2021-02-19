package com.dcy.hotspot.stackFrame;

/**
 * The Demo explore  after compiler compiling the class some methods are confirmed
 * The class inorder to verify the Static Method how to analyse in hotspot.
 * Use javap to analyse  byte of the class and observer Code.We can discover
 * in main method use invokestatic instruct to call sayHello() and sign a symbolic reference,when
 * compiler to compile the class.
 */
public class StaticMethodResolution {
    public static void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        StaticMethodResolution.sayHello();
    }
}
