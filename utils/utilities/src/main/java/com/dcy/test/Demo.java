package com.dcy.test;

/**
 * @author duanchunyu
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年05月11日 10:37:00
 */
public class Demo {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < 10; i++) {
            System.out.println(n >>>= 1);
        }
    }
}
