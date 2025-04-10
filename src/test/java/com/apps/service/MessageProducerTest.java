package com.apps.service;

import com.apps.dto.MessageRequest;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

public class MessageProducerTest {

    @Test
    public void testSendMessage() {
        // Use type-safe generic KafkaTemplate
        KafkaTemplate<String, MessageRequest> kafkaTemplate = mock(KafkaTemplate.class);
        MessageProducer producer = new MessageProducer(kafkaTemplate);

        // Create test message
        MessageRequest testMessage = new MessageRequest("TestUser", "Hello from test");

        // Call producer method
        producer.sendMessage(testMessage);

        // Verify interaction with KafkaTemplate
        verify(kafkaTemplate, times(1)).send("my-topic", testMessage);
    }
}
