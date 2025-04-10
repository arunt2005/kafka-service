package com.apps.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MessageConsumerTest {

    @Test
    void testConsume() {
        MessageConsumer consumer = new MessageConsumer();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String message = "Test message";
        consumer.consume(message);

        assertTrue(out.toString().contains("Consumed message: Test message"));
    }
}
