package com.starter.play.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "Test", groupId = "myGroup") // Replace with your desired topic name and group ID
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
