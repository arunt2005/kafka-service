package com.apps.controller;

import com.apps.dto.MessageRequest;
import com.apps.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy hh:mm:ss:SSS a"));
        MessageRequest messageRequest = new MessageRequest(request.getSender(), request.getContent().concat("  :: ").concat(timestamp));

        messageProducer.sendMessage(messageRequest);
        return "Message sent to Kafka topic!" + "\n\n" + messageRequest.getSender() + "\n" + messageRequest.getContent();
    }
}
