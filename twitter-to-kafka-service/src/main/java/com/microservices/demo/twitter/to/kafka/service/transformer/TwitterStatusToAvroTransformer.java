package com.microservices.demo.twitter.to.kafka.service.transformer;

import com.microservices.demo.kafka.avro.model.TwitterKafkaModel;
import org.springframework.stereotype.Component;
import twitter4j.Status;

@Component
public class TwitterStatusToAvroTransformer {

    public TwitterKafkaModel getTwitterAvroModelFromStatus(Status status) {
        return TwitterKafkaModel
                .builder()
                .id(status.getId())
                .userId(status.getUser().getId())
                .text(status.getText())
                .createdAt(status.getCreatedAt().getTime())
                .build();
    }
}
