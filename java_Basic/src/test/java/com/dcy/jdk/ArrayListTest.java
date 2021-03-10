package com.dcy.jdk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ArrayListTest {

    /**
     * understand forEach
     */
    @Test
    public void testForEach(){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            integers.add(i);
        }
        long startForEach = System.currentTimeMillis();
        integers.forEach(x-> System.out.println(x));
        long endForEach = System.currentTimeMillis();
        System.out.println("forEach:" + (endForEach-startForEach));

        long startForEachLan = System.currentTimeMillis();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        long endForEachLan = System.currentTimeMillis();
        System.out.println("forEachLan"+(endForEachLan-startForEachLan));
    }
}
