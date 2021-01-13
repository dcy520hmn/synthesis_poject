package com.dcy.iMyBatis.config;

/**
 * 用来保存xml文件中的resultType与sql语句的对应关系。
 * 作用是方便查询结果后，讲结果集封装到Java对象中。
 */
public class Mapper {
    private String resultType;
    private String sql;

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
