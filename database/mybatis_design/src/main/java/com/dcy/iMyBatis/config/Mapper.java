package com.dcy.iMyBatis.config;

/**
 * ��������xml�ļ��е�resultType��sql���Ķ�Ӧ��ϵ��
 * �����Ƿ����ѯ����󣬽��������װ��Java�����С�
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
