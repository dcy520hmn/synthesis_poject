package com.springboot.config.readYml.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author duanchunyu
 * @version 1.0.0
 * @Description 使用@Value注解来读取yml
 * @createTime 2021年05月17日 11:16:00
 */
@ConfigurationProperties(prefix = "userinfo")
public class UserPropertiesMethod_02 {
    /**
     * 用户编号
     */
    private int userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 博客地址
     */
    private String blogUrl;

    /**
     * 兴趣爱好
     */
    private String[] hobbys;

    /**
     * 备注信息
     */
    private String blogRemark;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public String getBlogRemark() {
        return blogRemark;
    }

    public void setBlogRemark(String blogRemark) {
        this.blogRemark = blogRemark;
    }
}
