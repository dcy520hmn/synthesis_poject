package com.rabbitmq.models.work_Model;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 自动ACK
 */
public class Recv {
    private final static String QUEUE_NAME = "test_work_queue";
 
    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        //创建会话通道,生产者和mq服务所有通信都在channel通道中完成
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //设置每个消费者同时只能处理一条消息，在手动ack下生效
        channel.basicQos(1);
        // 监听队列，第二个参数：是否自动进行消息确认。
        //参数：String queue, boolean autoAck, Consumer callback
        channel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(channel){
            // 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //交换机
                String exchange = envelope.getExchange();
                //消息id，mq在channel中用来标识消息的id，可用于确认消息已接收
                long deliveryTag = envelope.getDeliveryTag();
                // body 即消息体
                String msg = new String(body,"utf-8");
                System.out.println(" [消费者1] received : " + msg + "!");
                channel.basicAck(envelope.getDeliveryTag(),false);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}