package com.dcy.someTest;

import com.dcy.pojo.Student;

import java.util.ArrayList;
import java.util.List;


public class T {
    public static void main(String[] args) {
        ArrayList<Integer> integer1 = new ArrayList<>();
        integer1.add(1);
        integer1.add(2);
        integer1.add(3);
        integer1.add(4);
        List<Integer> integers = integer1.subList(2, 3);
        integers.add(0);
        System.out.println(integers);
    }
}
