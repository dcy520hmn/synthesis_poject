package com.dcy.iMyBatis.config;


import java.util.Map;

public class Configuration {

    private String driver;
    private String url;
    private String password;
    private String username;

    /**
     * key:namespace.·½·¨Ãû
     * value:[resultType:sqlÓï¾ä]
     */
    private Map<String, Mapper> mappers;

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers = mappers;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

