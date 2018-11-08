package com.btpn.chips.mskevingraphql.kafka.service;

import com.btpn.chips.mskevingraphql.kafka.model.WalletCreationModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class KafkaProducerServiceTest {

    private static final String KAFKA_TOPIC = "test";

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @MockBean
    private KafkaTemplate kafkaTemplate;

    @Test
    public void sendData_expectSuccessfullyRecieveMessageOnConsumer_whenObjectIsWalletCreationModel() throws InterruptedException {
        WalletCreationModel walletCreationModel = new WalletCreationModel();

        kafkaProducerService.sendData(KAFKA_TOPIC, walletCreationModel);

        verify(kafkaTemplate, times(1)).send(KAFKA_TOPIC, walletCreationModel);
    }
}