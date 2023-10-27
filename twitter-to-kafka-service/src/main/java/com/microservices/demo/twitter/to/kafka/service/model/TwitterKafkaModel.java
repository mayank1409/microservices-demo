package com.microservices.demo.twitter.to.kafka.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TwitterKafkaModel implements Serializable {
    private long createdAt;
    private long id;
    private String text;
    private long userId;
}
