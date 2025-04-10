package com.apps.service;

import com.apps.dto.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final KafkaTemplate<String, MessageRequest> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, MessageRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MessageRequest request) {
        kafkaTemplate.send("my-topic", request);
        System.out.println("Produced message: " + request);
    }
}
