package com.dcy;

import com.dcy.pojo.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        //1.创建configuration对象
        Configuration cfg = new Configuration().configure("WEB-INF/hibernate.cfg.xml");;
        SessionFactory factory = cfg.buildSessionFactory();
        //4.从工厂中获取session连接
        Session session = factory.openSession();
        //5.执行操作
        List<Account> list = session.createQuery("from Account ").list();
        //6.关闭连接
        session.close();
        factory.close();
    }
}
