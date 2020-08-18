package com.dcy.mapper;

import com.dcy.pojo.Account;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;


public class AccountMapper extends HibernateDaoSupport {
    public Account findAccountById(Integer id){
        return getHibernateTemplate().execute(new HibernateCallback<Account>() {
            @Override
            public Account doInHibernate(Session session) throws HibernateException {
                String sql = "from Account where id =:id";
                Query query = session.createQuery(sql,Account.class);
                query.setInteger("id",id);
                List list = query.list();
                return (Account) list.get(0);
            }
        });
    }
}
