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
     * �ڵ㣺�־á���ʱ -e��˳�� -s
     */
    @Test
    public void testCreateNode() throws Exception {
        String s = client.create().forPath("/app1");
        System.out.println(s);
    }

    /**
     * �ڵ㣺�־á���ʱ -e��˳�� -s
     * �����ڵ�
     */
    @Test
    public void testCreateNodeOfValue() throws Exception {
        String s = client.create().forPath("/aa_1","hh".getBytes());
        System.out.println(s);
    }


    //�����ڵ㲻���ڣ�������д���,�Ҵ����������͵Ľڵ�
    //create -e /aa2
    //create -e /aa2/p1
    @Test
    public void testCreateENode() throws Exception {
        String s = client.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/aa2/p1","h".getBytes());
        System.out.println(s);
    }

    //��ѯ�ڵ�ֵ get /aa1/p1
    @Test
    public void testGetValue() throws Exception {
        byte[] bytes = client.getData().forPath("/aa2/p1");
        System.out.println(new String(bytes));
    }


    //��ѯ�ڵ� ls
    @Test
    public void testLs() throws Exception {
        List<String> strings = client.getChildren().forPath("/");
        System.out.println(strings);
    }

    //���½ڵ��е�ֵ set /aa2/p1 w
    @Test
    public void testUpdateNode() throws Exception {
        Stat stat = client.setData().forPath("/aa2/p1", "w".getBytes());
        System.out.println(stat);
    }

    //ɾ���ڵ㣬�������ڵ��µ������ӽڵ�
    @Test
    public void testDeleteNode() throws Exception {
        //Void unused = client.delete().forPath("/aa");
        client.delete().deletingChildrenIfNeeded().forPath("/");
    }



}
