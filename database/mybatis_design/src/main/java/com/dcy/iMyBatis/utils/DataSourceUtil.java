package com.dcy.iMyBatis.utils;

import com.dcy.iMyBatis.config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * »ñµÃconnection
 */
public class DataSourceUtil {

    public static Connection getConnection(Configuration configuration){
        Connection connection;
        try{
            Class.forName(configuration.getDriver());
            connection = DriverManager.getConnection(configuration.getUrl(),configuration.getUsername(),
                    configuration.getPassword());
            return connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
