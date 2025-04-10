package com.apps.service;

import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

class MessageProducerTest {

    @Test
    void testSendMessage() {
        KafkaTemplate<String, String> kafkaTemplate = mock(KafkaTemplate.class);
        MessageProducer producer = new MessageProducer(kafkaTemplate);

        String testMessage = "Hello Kafka!";
        producer.sendMessage(testMessage);

        verify(kafkaTemplate, times(1)).send("my-topic", testMessage);
    }
}
