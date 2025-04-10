package com.apps.controller;

import com.apps.dto.MessageRequest;
import com.apps.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageProducer messageProducer;

    @Autowired
    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping
    public String sendMessage(@RequestBody MessageRequest request) {
        messageProducer.sendMessage(request);
        return "Message sent to Kafka topic!";
    }
}
