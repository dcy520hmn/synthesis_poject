package com.dcy.java.util.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamStu {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("张无忌");
        names.add("周芷若");
        names.add("赵敏");
        names.add("张强");
        names.add("张三丰");

        List<String> namesOfZhang = new ArrayList<>();
        for (String name : names) {
            if(name.startsWith("张")){
                namesOfZhang.add(name);
            }
        }

        List<String> nameZhangOfThr = new ArrayList<>();
        for (String name : namesOfZhang) {
            if(name.length()==3){
                nameZhangOfThr.add(name);
            }
        }

        for (String name : nameZhangOfThr) {
            System.out.println(name);
        }

        //stream
        names.stream().filter(name->name.startsWith("张")).
                filter(name->name.length()==3).forEach(name-> System.out.println(name));
    }
}
