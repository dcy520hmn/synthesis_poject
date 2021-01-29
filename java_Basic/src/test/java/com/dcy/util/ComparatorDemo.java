package com.dcy.util;

import com.dcy.pojo.Student;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorDemo {

    private ArrayList<Student> students;

    @Before
    public void before() throws IOException {
        students = new ArrayList<>();
        Student dcy1 = new Student(1, 1, "dcy1", 39);
        Student dcy2 = new Student(2, 1, "dcy2", 19);
        Student dcy3 = new Student(3, 2, "dcy3", 30);
        Student dcy4 = new Student(4, 2, "dcy4", 45);
        Student dcy5 = new Student(5, 3, "dcy5", 22);
        Student dcy6 = new Student(6, 4, "dcy6", 30);
        //Student dcy7 = new Student(6, 4, "dcy6", null);
        students.add(dcy1);
        students.add(dcy2);
        students.add(dcy3);
        students.add(dcy4);
        students.add(dcy5);
        students.add(dcy6);
        //students.add(dcy7);
    }

    //compare
    @Test
    public void test1() throws IOException {
        List<Student> collect = students.stream().sorted((stu1, stu2) -> stu1.getAge()-stu2.getAge()).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test() throws IOException {
        List<Student> collect = students.stream()
                //.sorted(Comparator.comparing(Student::getAge,(x,y)->x-y).reversed())
                .sorted(Comparator.comparing(Student::getAge,Comparator.nullsLast(Integer::compareTo)).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
