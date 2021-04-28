package com.dcy.common.java.reflect;

import com.dcy.pojo.StudentReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author duanchunyu
 * @version 1.0.0
 * @Description 反射
 * @createTime 2021年04月28日 09:33:00
 */
public class ReflectPlay {

    /**
     * @description 获取class对象
     * @author duanchunyu
     * @updateTime 2021/4/28 10:11
     * @throws
     */
    public void getClassObject() throws ClassNotFoundException {
        //方式一
        StudentReflect student = new StudentReflect();
        Class studentClass = student.getClass();
        //方式二
        Class studentClass1 = StudentReflect.class;
        //方式三
        Class studentClass2 = Class.forName("com.dcy.pojo.Student");
    }

    /**
     * @description 反射获取构造方法
     * @author duanchunyu
     * @updateTime 2021/4/28 10:25
     * @throws
     */
    public void reflectConstructor() throws Exception {
        Class studentClass = Class.forName("com.dcy.pojo.StudentReflect");
        //遍历构造方法
        Constructor[] constructors = studentClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("所有的public构造方法："+constructors);
        }

        Constructor[] declaredConstructors = studentClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("所有的构造方法："+constructors);
        }

        //创建对象
        Constructor constructor = studentClass.getConstructor(String.class);
        StudentReflect studentReflect = (StudentReflect) constructor.newInstance("张三");
        System.out.println(studentReflect.getName());
    }

    /**
     * @description 反射获取成员变量
     * @author duanchunyu
     * @updateTime 2021/4/28 10:43
     * @throws
     */
    public void reflectField() throws Exception{
        Class studentClass = Class.forName("com.dcy.pojo.StudentReflect");
        Constructor constructor = studentClass.getConstructor();
        Object o = constructor.newInstance();
        Field name = studentClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"张三");
        Method getName = studentClass.getDeclaredMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);

        Package aPackage = studentClass.getPackage();
        System.out.println(aPackage.getName());
    }

    public static void main(String[] args) throws Exception{
        ReflectPlay reflectPlay = new ReflectPlay();
        reflectPlay.reflectField();
    }
}
