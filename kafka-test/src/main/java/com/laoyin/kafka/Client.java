package com.laoyin.kafka;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年08月06日 9:54 上午
 */
public class Client {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "111.229.113.35:9092");
        properties.setProperty("acks", "all");
        properties.setProperty("retries", "0");
        properties.setProperty("batch.size", "16384");
        properties.setProperty("linger.ms", "1");
        properties.setProperty("buffer.memory", "33554432");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> client = new KafkaProducer<>(properties);
        for (int i = 0; i < 100; i++) {
            client.send(new ProducerRecord<>("demo", Integer.toString(i), Integer.toString(i)));
        }
        client.close();
    }
}
