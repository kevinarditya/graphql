//package com.btpn.chips.mskevingraphql.kafka.service;
//
//import com.btpn.chips.mskevingraphql.kafka.model.UserCreationModel;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.CountDownLatch;
//
//@Component
//public class KafkaConsumerService {
//
//    private CountDownLatch latch = new CountDownLatch(1);
//
//    private ObjectMapper objectMapper;
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//
//    @KafkaListener(topics = "User-Wallet-Creation")
//    public UserCreationModel consume(@Payload String dataRecieve) {
//        try {
//            UserCreationModel userCreationModel = objectMapper.readValue(dataRecieve, UserCreationModel.class);
//
//            latch.countDown();
//
//            return userCreationModel;
//        } catch (Exception ex) {
//
//        }
//        return null;
//    }
//}
//
