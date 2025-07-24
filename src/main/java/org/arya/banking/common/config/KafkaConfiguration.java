package org.arya.banking.common.config;

import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.arya.banking.common.constants.kafka.KafkaConstants.BOOTSTRAP_SERVER;
import static org.arya.banking.common.constants.kafka.KafkaConstants.KAFKA_AVRO_DESERIALIZER;
import static org.arya.banking.common.constants.kafka.KafkaConstants.SCHEMA_REGISTRY_URL;
import static org.arya.banking.common.constants.kafka.KafkaConstants.STRING_DESERIALIZER;
import static org.arya.banking.common.constants.kafka.KafkaConstants.STRING_SERIALIZER;
import static org.arya.banking.common.constants.kafka.KafkaConstants.KAFKA_AVRO_SERIALIZER;


@Configuration
public class KafkaConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaRegistryUrl;

    private Map<String, Object> commonConfig() {

        Map<String, Object> configs = new HashMap<>();
        configs.put(BOOTSTRAP_SERVER, bootstrapServers);
        configs.put(SCHEMA_REGISTRY_URL, schemaRegistryUrl);
        return configs;
    }

    private Map<String, Object> producerConfig() {

        Map<String, Object> producerConfig = commonConfig();
        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, STRING_SERIALIZER);
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KAFKA_AVRO_SERIALIZER);
        return producerConfig;
    }

    private Map<String, Object> consumerConfig(String groupId) {

        Map<String, Object> consumerConfig = commonConfig();
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, STRING_DESERIALIZER);
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KAFKA_AVRO_DESERIALIZER);
        consumerConfig.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        consumerConfig.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        return consumerConfig;
    }

    @Bean
    public <K, V> ProducerFactory<K, V> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    public <K, V> ConsumerFactory<K, V> consumerFactory(String groupId) {
        return new DefaultKafkaConsumerFactory<>(consumerConfig(groupId));
    }

    public <K, V> ConcurrentKafkaListenerContainerFactory<K, V> kafkaListerFactory(String groupId) {
        ConcurrentKafkaListenerContainerFactory<K, V> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(groupId));
        return factory;
    }
}
