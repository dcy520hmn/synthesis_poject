package com.dcy.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * 消费kafka中消息
 *
 */
public class ConsumerKafka {
    public static void main(String[] args) {
        Properties props = new Properties();
        //kafka 集群,broker-list
        props.put("bootstrap.servers", "centos-node-132:9092,centos-node-133:9092,centos-node-134:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "false");//自动提交offset，可用设置手动提交方式
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("first"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());

            //当设置手动提交offset时，进行一下操作。
            consumer.commitSync();// 同步提交，当前线程会阻塞，直到offset提交成功

            //异步提交
           /* consumer.commitAsync(new OffsetCommitCallback() {
                @Override
                public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {
                    if (exception != null) {
                        System.err.println("Commit failed for" + offsets);
                    }
                }
            });*/
        }

    }
}
