package com.mytest;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CuratorOfCRUDApi {
    CuratorFramework client;

    @Before
    public void testConnection(){
        RetryForever retryForever = new RetryForever(100);
        client = CuratorFrameworkFactory.builder().connectString("192.168.61.129:2181,192.168.61.130:2181,192.168.61.131:2181")
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryForever)
                .namespace("itheima")
                .build();
        client.start();
    }

    /**
     * 节点：持久、临时 -e、顺序 -s
     */
    @Test
    public void testCreateNode() throws Exception {
        String s = client.create().forPath("/app1");
        System.out.println(s);
    }

    /**
     * 节点：持久、临时 -e、顺序 -s
     * 创建节点
     */
    @Test
    public void testCreateNodeOfValue() throws Exception {
        String s = client.create().forPath("/aa_1","hh".getBytes());
        System.out.println(s);
    }


    //若父节点不存在，则则进行创建,且创建其它类型的节点
    //create -e /aa2
    //create -e /aa2/p1
    @Test
    public void testCreateENode() throws Exception {
        String s = client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/aa2/p1","h".getBytes());
        System.out.println(s);
    }

    //查询节点值 get /aa1/p1
    @Test
    public void testGetValue() throws Exception {
        byte[] bytes = client.getData().forPath("/aa2/p1");
        System.out.println(new String(bytes));
    }


    //查询节点 ls
    @Test
    public void testLs() throws Exception {
        List<String> strings = client.getChildren().forPath("/");
        System.out.println(strings);
    }

    //更新节点中的值 set /aa2/p1 w
    @Test
    public void testUpdateNode() throws Exception {
        Stat stat = client.setData().forPath("/aa2/p1", "w".getBytes());
        System.out.println(stat);
    }

    //删除节点，包括父节点下的所有子节点
    @Test
    public void testDeleteNode() throws Exception {
        //Void unused = client.delete().forPath("/aa");
        client.delete().deletingChildrenIfNeeded().forPath("/");
    }



}
