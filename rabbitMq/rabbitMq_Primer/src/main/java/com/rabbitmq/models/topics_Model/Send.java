package com.rabbitmq.models.topics_Model;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtil;

/**
 * Topics 通配符模式（交换机类型：topics）
 */
public class Send {
    private final static String EXCHANGE_NAME = "test_topic_exchange";
 
    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明exchange，指定类型为topic
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        // 消息内容
        String message = "这是一只行动迅速的橙色的兔子";
        // 发送消息，并且指定routing key为：quick.orange.rabbit
        channel.basicPublish(EXCHANGE_NAME, "quick.orange.rabbit", null, message.getBytes());
        System.out.println(" [动物描述：] Sent '" + message + "'");
 
        channel.close();
        connection.close();
    }
}