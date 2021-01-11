package com.dcy.iMyBatis.config;


import java.util.Map;

public class Configuration {

    private Map<String, Mapper> mappers;

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers = mappers;
    }
}

