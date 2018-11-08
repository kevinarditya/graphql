package com.btpn.chips.mskevingraphql.kafka.config;

import com.btpn.chips.mskevingraphql.kafka.model.UserCreationModel;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAsync
public class KafkaProducerConfiguration {

    private Environment environment;

    @Autowired
    public KafkaProducerConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();

        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.environment.getProperty("spring.kafka.bootstrap-servers"));
        configProps.put(ProducerConfig.CLIENT_ID_CONFIG, this.environment.getProperty("spring.kafka.producer.client-id"));
        configProps.put(ProducerConfig.RETRIES_CONFIG, this.environment.getProperty("spring.kafka.producer.retries"));
        configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, this.environment.getProperty("spring.kafka.producer.batch-size"));
        configProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, this.environment.getProperty("spring.kafka.producer.buffer-memory"));
        configProps.put(ProducerConfig.LINGER_MS_CONFIG, this.environment.getProperty("spring.kafka.producer.linger-ms"));

        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
