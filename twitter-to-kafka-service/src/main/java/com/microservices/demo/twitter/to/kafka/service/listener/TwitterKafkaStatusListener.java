package com.microservices.demo.twitter.to.kafka.service.listener;

import com.microservices.demo.twitter.to.kafka.service.config.KafkaConfigData;
import com.microservices.demo.twitter.to.kafka.service.model.TwitterKafkaModel;
import com.microservices.demo.twitter.to.kafka.service.service.KafkaProducer;
import com.microservices.demo.twitter.to.kafka.service.transformer.TwitterStatusToKafkaTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.StatusAdapter;

@Component
public class TwitterKafkaStatusListener extends StatusAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStatusListener.class);

    private final KafkaConfigData kafkaConfigData;

    private final KafkaProducer<Long, TwitterKafkaModel> kafkaProducer;

    private final TwitterStatusToKafkaTransformer twitterStatusToKafkaTransformer;

    public TwitterKafkaStatusListener(KafkaConfigData configData,
                                      KafkaProducer<Long, TwitterKafkaModel> producer,
                                      TwitterStatusToKafkaTransformer transformer) {
        this.kafkaConfigData = configData;
        this.kafkaProducer = producer;
        this.twitterStatusToKafkaTransformer = transformer;
    }

    @Override
    public void onStatus(Status status) {
        LOG.info("Received status text {} sending to kafka topic {}", status.getText(), kafkaConfigData.getTopicName());
        TwitterKafkaModel twitterKafkaModel = twitterStatusToKafkaTransformer.getTwitterKafkaModelFromStatus(status);
        kafkaProducer.send(kafkaConfigData.getTopicName(), twitterKafkaModel.getUserId(), twitterKafkaModel);
    }
}
