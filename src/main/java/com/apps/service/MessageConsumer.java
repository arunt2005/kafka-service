package com.apps.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "my-topic", groupId = "kafka-service-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
