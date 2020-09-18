package com.example.defka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    public static Logger logger = LoggerFactory.getLogger(Producer.class);

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    public Producer(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(String topic, int key, String payload) {
        kafkaTemplate.send(topic, key, payload);
        kafkaTemplate.flush();
        logger.info("produce success!");
    }
}
