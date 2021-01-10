package com.mytest.com.distributedLock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

public class TicksOf12306 implements Runnable {

    private int tickets = 10;//���ݿ��Ʊ��
    private InterProcessMutex lock ;

    public TicksOf12306() {
        //���Բ���
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        //2.�ڶ��ַ�ʽ
        //CuratorFrameworkFactory.builder();
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("192.168.61.129:2181,192.168.61.130:2181,192.168.61.131:2181")
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryPolicy)
                .build();
        //��������
        client.start();
        lock = new InterProcessMutex(client,"/lock");
    }

    @Override
    public void run() {
        while(true){
            //��ȡ��
            try {
                lock.acquire(3, TimeUnit.SECONDS);
                if(tickets > 0){
                    System.out.println(Thread.currentThread()+":"+tickets);
                    Thread.sleep(100);
                    tickets--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                //�ͷ���
                try {
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
