package com.btpn.chips.mskevingraphql.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerService {

    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Async
    public void sendData(String topic, Object data) {
        try {
            this.kafkaTemplate.send(topic, data);
        } catch (Exception ex) {

        } finally {
            this.kafkaTemplate.flush();
        }
    }
}
