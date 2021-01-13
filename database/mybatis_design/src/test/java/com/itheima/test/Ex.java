package com.itheima.test;

public class Ex {
    public static void main(String[] args) {
        String s = "com.dcy.mapper.UserDao.findAll";
        String method = "findAll";
        String[] split = s.split("\\.");
        String meth = split[split.length-1];
        System.out.println(meth);
    }
}
