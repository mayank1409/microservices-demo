package com.microservices.demo.twitter.to.kafka.service.init.impl;

import com.microservices.demo.twitter.to.kafka.service.config.KafkaConfigData;
import com.microservices.demo.twitter.to.kafka.service.init.StreamInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

@Component
public class KafkaStreamInitializer implements StreamInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaStreamInitializer.class);

    private final KafkaConfigData kafkaConfigData;
    private final KafkaAdmin kafkaAdmin;

    public KafkaStreamInitializer(KafkaConfigData kafkaConfigData, KafkaAdmin kafkaAdmin) {
        this.kafkaConfigData = kafkaConfigData;
        this.kafkaAdmin = kafkaAdmin;
    }

    @Override
    public void init() {
        
        LOG.info("Topics with name {} is ready for operations!", kafkaConfigData.getTopicName());
    }
}
