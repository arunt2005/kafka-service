package com.apps.service;

import com.apps.dto.MessageRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "my-topic", groupId = "kafka-service-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(MessageRequest message) {
        System.out.println("Consumed structured message: " + message);
    }
}
