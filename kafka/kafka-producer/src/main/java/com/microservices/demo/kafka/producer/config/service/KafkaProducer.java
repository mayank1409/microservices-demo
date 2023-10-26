package com.microservices.demo.kafka.producer.config.service;

import java.io.Serializable;

public interface KafkaProducer<K extends Serializable, V extends Serializable> {
    void send(String topicName, K key, V message);
}
