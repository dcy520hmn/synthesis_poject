package com.dcy.java.util.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamOfMethod {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("张无忌");
        names.add("周芷若");
        names.add("赵敏");
        names.add("张强");
        names.add("张三丰");
        ArrayList<String> names1 = new ArrayList<>();
        names.add("张无忌");
        names.add("周芷若");
        names.add("赵敏");
        Stream.concat(names.stream(),names1.stream()).forEach(System.out::println);
    }
}
