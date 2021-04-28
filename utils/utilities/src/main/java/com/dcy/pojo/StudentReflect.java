package com.dcy.pojo;

/**
 * @author duanchunyu
 * @version 1.0.0
 * @Description 反射测试实体类
 * @createTime 2021年04月28日 10:21:00
 */
public class StudentReflect {

    private Integer stuNo;
    private String name;

    public StudentReflect() {
    }

    public StudentReflect(String name) {
        this.name = name;
        System.out.println("姓名："+name);
    }

    public StudentReflect(Integer stuNo, String name) {
        this.stuNo = stuNo;
        this.name = name;
        System.out.println("姓名："+name+"学号："+ stuNo);
    }

    protected StudentReflect(boolean n){
        System.out.println("受保护的构造方法 n="+n);
    }

    private StudentReflect(Integer stuNo){
        System.out.println("私有构造方法 学号="+stuNo);
    }

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
