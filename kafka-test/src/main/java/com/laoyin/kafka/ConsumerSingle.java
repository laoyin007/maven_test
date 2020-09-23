package com.laoyin.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年08月06日 2:50 下午
 */

@Slf4j
public class ConsumerSingle {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "111.229.113.35:9092");
        properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.setProperty("group.id", "demo01");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        List<PartitionInfo> partitionInfos = consumer.partitionsFor("demo");

        List<TopicPartition> partitions = partitionInfos.stream()
                .map(s -> new TopicPartition(s.topic(), s.partition()))
                .collect(Collectors.toList());
        consumer.assign(partitions);
//        consumer.subscribe(Collections.singletonList("demo"));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100L));
                for (ConsumerRecord<String, String> record : records) {
                    log.info("topic {}, partition {}, offset {}, key {}, value {}", record.topic(), record.partition(), record.offset()
                            , record.key(), record.value());
                }
            }
        } finally {
            consumer.close();
        }

    }
}
