package com.apps.service;

import com.apps.dto.MessageRequest;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

public class MessageProducerTest {

    @Test
    public void testSendMessage() {
        KafkaTemplate<String, MessageRequest> kafkaTemplate = mock(KafkaTemplate.class);
        MessageProducer producer = new MessageProducer(kafkaTemplate);

        MessageRequest testMessage = new MessageRequest("TestUser", "Hello from test");

        producer.sendMessage(testMessage);

        verify(kafkaTemplate, times(1)).send("my-topic", testMessage);
    }
}
