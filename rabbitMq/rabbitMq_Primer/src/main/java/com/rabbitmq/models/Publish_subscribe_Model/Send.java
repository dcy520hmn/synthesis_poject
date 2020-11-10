package com.rabbitmq.models.Publish_subscribe_Model;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtil;

/**
 * 交换机类型：Fanout，也称为广播
 */
public class Send {

    private final static String EXCHANGE_NAME = "test_fanout_exchange";
 
    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明exchange，指定类型为fanout
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        for (int i = 0; i < 50; i++) {
            // 消息内容
            String message = "注册成功!"+i;
            // 发布消息到Exchange
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            System.out.println(" [生产者] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}