package com.dcy.hotspot.executeSystem.practice.run;

import com.dcy.hotspot.executeSystem.practice.JavaclassExecuter;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 模拟一个客户端
 */
public class Run {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("src/main/java/com/dcy/hotspot/executeSystem/practice/run/TestC.class");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
        System.out.println(JavaclassExecuter.execute(b));
    }
}
