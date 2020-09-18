package com.example.defka.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ListenerTest {
    @Autowired
    private  Listener listener;
    @Autowired
    private Producer producer;

    @Test
    void send() throws Exception {
        producer.produce("joy-topic", 0, "foo");

        assertThat(this.listener.getLatch().await(10, TimeUnit.SECONDS)).isTrue();
    }
}
