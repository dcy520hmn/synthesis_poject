package com.dcy.someTest;

import com.dcy.pojo.Student;

import java.util.ArrayList;
import java.util.List;


public class T {
    public static void main(String[] args) {
        ArrayList<Integer> integer1 = new ArrayList<>();
        ArrayList<Integer> integer2 = new ArrayList<>();
        integer1.add(1);
        integer1.add(2);
        integer2.add(2);
        integer2.add(3);
        integer2.add(4);
        for (int i = 1; i < integer2.size(); i++) {
            integer1.add(integer2.get(i));
        }
        System.out.println(integer1);
    }
}
