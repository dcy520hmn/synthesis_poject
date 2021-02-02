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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流的学习
 */
public class StreamDemo {

    private List<String> words;

    @Before
    public void before() throws IOException {
        //流的概念
        String contents = new String(Files.readAllBytes(Paths.get("Test.txt")), StandardCharsets.UTF_8);
        words = Arrays.asList(contents.split("\\PL+"));
    }

    /**
     * filer
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

    @Test
    public void test6() throws IOException{

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
