package com.dcy.util;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流学习
 */
public class StreamDemo {

    //记录文件中的单词个数
    private List<String> words;

    //通过对Test文件中的字符进行处理。
    @Before
    public void before() throws IOException {
        //流的概念
        String contents = new String(Files.readAllBytes(Paths.get("Test.txt")), StandardCharsets.UTF_8);
        words = Arrays.asList(contents.split("\\PL+"));
    }

    /**
     * filer/count
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        long count = words.stream().filter(word -> word.length() > 12).count();
        System.out.println(count);
    }

    /**
     * map
     * @throws IOException
     */
    @Test
    public void test2() throws IOException{
        List<String> collect = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test4() throws IOException{
        List<String> collect = words.stream().map(w -> w.substring(0, 1)).collect(Collectors.toList());
        System.out.println(collect);
    }

    //flatMap，压平
    @Test
    public void test5() throws IOException{
//        List<Stream<String>> collect = words.stream().map(w -> codePoints(w)).collect(Collectors.toList());
        List<String> collect = words.stream().flatMap(w -> codePoints(w)).collect(Collectors.toList());
        System.out.println(collect);
    }

    //anyMatch
    @Test
    public void test6() throws IOException{
        boolean b = words.stream().anyMatch(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 12;
            }
        });
        System.out.println(b);
    }

    //concat
    @Test
    public void test7() throws IOException{
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

    //anyMatch表示，判断的条件里，任意一个元素成功，返回true
    //allMatch表示，判断条件里的元素，所有的都是，返回true
    //noneMatch跟allMatch相反，判断条件里的元素，所有的都不是，返回true
    //count统计个数
    @Test
    public void test8() throws IOException{
        List<String> strs = Arrays.asList("a", "a", "a", "a", "b");
        boolean aa = strs.stream().anyMatch(str -> str.equals("a"));
        boolean bb = strs.stream().allMatch(str -> str.equals("a"));
        boolean cc = strs.stream().noneMatch(str -> str.equals("a"));
        long count = strs.stream().filter(str -> str.equals("a")).count();
        System.out.println(aa);// TRUE
        System.out.println(bb);// FALSE
        System.out.println(cc);// FALSE
        System.out.println(count);// 4
    }

    @Test
    public void test() throws IOException{

    }

    private  Stream<String> codePoints(String s){
        ArrayList<String> ret = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int j = s.offsetByCodePoints(i,1);
            ret.add(s.substring(i,j));
            i = j;
        }
        return ret.stream();
    }
}
