package com.microservices.demo.kafka.avro.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

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
