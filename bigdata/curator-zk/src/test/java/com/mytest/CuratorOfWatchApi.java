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

    //���Լ���NodeCache
    @Test
    public void testNodeCache() throws Exception {
        //����NodeCache����
        NodeCache nodeCache = new NodeCache(client, "/app1");
        //ע�������
        nodeCache.getListenable().addListener(() -> {
            System.out.println("�仯��");
            //��ȡ�仯֮�������
            byte[] data = nodeCache.getCurrentData().getData();
            System.out.println(new String(data));
        });
        //��������
        nodeCache.start(true);
        while (true) {
        }
    }


    //���Լ���patchChildCache
    @Test
    public void testPatchChildCache() throws Exception {
        //����NodeCache����
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app1", true);
        //ע�������
        pathChildrenCache.getListenable().addListener((client, event) -> {
            System.out.println("�仯��");
            System.out.println(event);
            if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)) {
                byte[] data = event.getData().getData();
                System.out.println("�仯֮���ֵΪ��" + new String(data));
            }
        });
        //��������
        pathChildrenCache.start();
        while (true) {
        }
    }

    //���Լ���TreeCache
    @Test
    public void testTreeCache() throws Exception {
        //����NodeCache����
        TreeCache treeCache = new TreeCache(client, "/app1");
        //ע�������
        treeCache.getListenable().addListener((client, event) -> {
            System.out.println("�仯��");
            System.out.println(event);
            byte[] data = event.getData().getData();
            System.out.println("�仯֮���ֵΪ��" + new String(data));
        });
        //��������
        treeCache.start();
        while (true) {
        }
    }
}
