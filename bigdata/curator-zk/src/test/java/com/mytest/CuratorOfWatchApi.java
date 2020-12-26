package com.mytest;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.RetryForever;
import org.junit.Before;
import org.junit.Test;

public class CuratorOfWatchApi {
    CuratorFramework client;

    @Before
    public void testConnection() {
        RetryForever retryForever = new RetryForever(100);
        client = CuratorFrameworkFactory.builder().connectString("192.168.61.129:2181")
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryForever)
                .namespace("itheima")
                .build();
        client.start();
    }

    //测试监听NodeCache
    @Test
    public void testNodeCache() throws Exception {
        //创建NodeCache对象
        NodeCache nodeCache = new NodeCache(client, "/app1");
        //注册监听器
        nodeCache.getListenable().addListener(() -> {
            System.out.println("变化了");
            //获取变化之后的数据
            byte[] data = nodeCache.getCurrentData().getData();
            System.out.println(new String(data));
        });
        //开启监听
        nodeCache.start(true);
        while (true) {
        }
    }


    //测试监听patchChildCache
    @Test
    public void testPatchChildCache() throws Exception {
        //创建NodeCache对象
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app1", true);
        //注册监听器
        pathChildrenCache.getListenable().addListener((client, event) -> {
            System.out.println("变化了");
            System.out.println(event);
            if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)) {
                byte[] data = event.getData().getData();
                System.out.println("变化之后的值为：" + new String(data));
            }
        });
        //开启监听
        pathChildrenCache.start();
        while (true) {
        }
    }

    //测试监听TreeCache
    @Test
    public void testTreeCache() throws Exception {
        //创建NodeCache对象
        TreeCache treeCache = new TreeCache(client, "/app1");
        //注册监听器
        treeCache.getListenable().addListener((client, event) -> {
            System.out.println("变化了");
            System.out.println(event);
            byte[] data = event.getData().getData();
            System.out.println("变化之后的值为：" + new String(data));
        });
        //开启监听
        treeCache.start();
        while (true) {
        }
    }
}
