package com.springboot;

import com.springboot.config.readYml.properties.UserPropertiesMethod_01;
import com.springboot.config.readYml.properties.UserPropertiesMethod_02;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author duanchunyu
 * @version 1.0.0
 * @Description 测试运行读取yml配置文件，其中EnableConfigurationProperties
 * 注解的作用是将配置有ConfigurationProperties注解的类UserPropertiesMethod_02
 * 扫描加入到IOC。也可以在UserPropertiesMethod_02使用@Component加入IOC（不在
 * 需要其中@EnableConfigurationProperties）。
 *
 * @createTime 2021年05月17日 11:18:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@EnableConfigurationProperties(UserPropertiesMethod_02.class)
public class ReadYmlTest {

    @Autowired
    private UserPropertiesMethod_01 userPropertiesMethod_01;

    @Autowired
    private UserPropertiesMethod_02 userPropertiesMethod_02;

    /**
     * 获取用户YAML配置信息
     * @author pan_junbiao
     */
    @Test
    public void getUserProperties_01()
    {
        System.out.println("获取application.yml配置文件中的信息：");
        System.out.println("用户编号：" + userPropertiesMethod_01.getUserId());
        System.out.println("用户名称：" + userPropertiesMethod_01.getUserName());
        System.out.println("博客地址：" + userPropertiesMethod_01.getBlogUrl());
        System.out.println("兴趣爱好：共" + userPropertiesMethod_01.getHobbys().length + "个，" + Arrays.toString(userPropertiesMethod_01.getHobbys()));
        System.out.println("备注信息：" + userPropertiesMethod_01.getBlogRemark());
    }

    @Test
    public void getUserProperties_02()
    {
        System.out.println("获取application.yml配置文件中的信息：");
        System.out.println("用户编号：" + userPropertiesMethod_02.getUserId());
        System.out.println("用户名称：" + userPropertiesMethod_02.getUserName());
        System.out.println("博客地址：" + userPropertiesMethod_02.getBlogUrl());
        System.out.println("兴趣爱好：共" + userPropertiesMethod_02.getHobbys().length + "个，" + Arrays.toString(userPropertiesMethod_01.getHobbys()));
        System.out.println("备注信息：" + userPropertiesMethod_02.getBlogRemark());
    }

}
