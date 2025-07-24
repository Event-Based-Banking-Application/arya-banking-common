package org.arya.banking.common.constants.kafka;

public interface KafkaConstants {

    String BOOTSTRAP_SERVER = "bootstrap.servers";
    String SCHEMA_REGISTRY_URL = "schema.registry.url";


    String STRING_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    String KAFKA_AVRO_SERIALIZER = "io.confluent.kafka.serializers.KafkaAvroSerializer";
    String STRING_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
    String KAFKA_AVRO_DESERIALIZER = "io.confluent.kafka.serializers.KafkaAvroDeserializer";

}
