package com.springboot.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TestDao {

    @Autowired
    private DataSource dataSource;

    public void testGetDataSource(){
        System.out.println(dataSource);
    }
}
