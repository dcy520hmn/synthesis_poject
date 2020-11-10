package com.rabbitmq.models.work_Model;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtil;

public class Send {

    private final static String QUEUE_NAME = "test_work_queue";

    public static void main(String[] args) {
        try {
            // 1、获取到连接
            Connection connection = ConnectionUtil.getConnection();
            // 2、从连接中创建通道，使用通道才能完成消息相关的操作
            Channel channel = connection.createChannel();
            // 3、声明（创建）队列
            //参数：String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 4、消息内容
            for (int i = 0; i < 50; i++) {
                String message = "task .. " + i;
                // 向指定的队列中发送消息
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
                Thread.sleep(i * 2);
            }
            //关闭通道和连接(资源关闭最好用try-catch-finally语句处理)
            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
