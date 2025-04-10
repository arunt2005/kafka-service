package com.apps.controller;

import com.apps.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping
    public String publishMessage(@RequestParam String message) {
        messageProducer.sendMessage(message);
        return "Message sent to Kafka topic!";
    }
}
