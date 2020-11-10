package com.dcy.mq.config;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class ReceiveHandler {


    //监听邮件队列
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue_email", durable = "true"),
            exchange = @Exchange(
                    value = "topic.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"topic.#.email.#","email.*"}))
    public void rece_email(String msg){
        System.out.println(" [邮件服务] received : " + msg + "!");
    }
 
    //监听短信队列
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue_sms", durable = "true"),
            exchange = @Exchange(
                    value = "topic.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"topic.#.sms.#"}))
    public void rece_sms(String msg){
        System.out.println(" [短信服务] received : " + msg + "!");
    }
}

/**
 * 属性说明：
 *
 * @Componet：类上的注解，注册到Spring容器
 *
 * @RabbitListener：方法上的注解，声明这个方法是一个消费者方法，需要指定下面的属性：
 *
 * bindings：指定绑定关系，可以有多个。值是@QueueBinding的数组。@QueueBinding包含下面属性：
 *
 * value：这个消费者关联的队列。值是@Queue，代表一个队列
 *
 * exchange：队列所绑定的交换机，值是@Exchange类型
 *
 * key：队列和交换机绑定的RoutingKey，可指定多个
 **/