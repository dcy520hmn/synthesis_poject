package com.dcy.mapper;

import com.dcy.pojo.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class AccountMapper extends HibernateDaoSupport {

    @Autowired
    private SessionFactory sessionFactory;

    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public  Account accountMapper(Integer accountId){
        Query query=getSession().createQuery("from Account where  id = ?");
        return null;
    }
}
