package com.dcy.iMyBatis.io;

import java.io.InputStream;

/**
 * ¼ÓÔØÅäÖÃÎÄ¼ş
 */
public class Resources {
    public static InputStream getResourceAsStream(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
