package com.example.defka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Listener {
    public static Logger logger = LoggerFactory.getLogger(Listener.class);

    private final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "joy-topic")
    public void listen(String record, Acknowledgment acknowledgment) {
        logger.info(record);
        acknowledgment.acknowledge();
        this.latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
