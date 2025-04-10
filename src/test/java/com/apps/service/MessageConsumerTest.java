package com.apps.service;

import com.apps.dto.MessageRequest;
import org.junit.jupiter.api.Test;

public class MessageConsumerTest {

    @Test
    public void testConsumeMessage() {
        MessageConsumer consumer = new MessageConsumer();

        MessageRequest message = new MessageRequest("TestUser", "This is a test message");
        consumer.consume(message);
    }
}
