package com.dcy.someTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class T {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Object[] objects = integers.toArray(integers.toArray());
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
