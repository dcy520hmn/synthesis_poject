package com.rabbitmq.customer;

import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtil;

public class Send {

    private final static String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) {
        // 1、获取到连接
        try {
            Connection connection = ConnectionUtil.getConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
