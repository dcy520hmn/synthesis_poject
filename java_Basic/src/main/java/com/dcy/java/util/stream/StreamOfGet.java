package com.dcy.java.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StreamOfGet {
    public static void main(String[] args) {
        //单列集合获取流
        //method1();
        //双列集合获取流
        //method2();
        //数据获得流
        method3();
        //统一数据类型获取流
        //method4();
    }

    private static void method4() {
        Stream.of(1,2,3,4,5).forEach(System.out::println);
    }

    private static void method3() {
        String[] words = new String[]{"dcy","hmn"};
        Arrays.asList(words).stream().forEach(System.out::println);
    }

    private static void method2() {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("dcy",22);
        map.put("hmn",22);
        map.keySet().stream().forEach(System.out::println);
        map.entrySet().stream().forEach(System.out::println);
    }

    //单列集合获取流
    public static void method1(){
        ArrayList<String> names = new ArrayList<>();
        names.add("张无忌");
        names.add("周芷若");
        names.add("赵敏");
        names.add("张强");
        names.add("张三丰");
        names.stream().forEach(System.out::println);
    }
}
