package org.arya.banking.common.kafka.constants;

public interface KafkaConstants {

    String BOOTSTRAP_SERVER = "bootstrap.servers";
    String SCHEMA_REGISTRY_URL = "schema.registry.url";


    String STRING_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    String KAFKA_AVRO_SERIALIZER = "io.confluent.kafka.serializers.KafkaAvroSerializer";
    String STRING_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer";
    String KAFKA_AVRO_DESERIALIZER = "io.confluent.kafka.serializers.KafkaAvroDeserializer";

    //kafka topic
    String AUTH_FAILED_TOPIC = "AUTH_SERVICE.LOGIN-FAILED.V1";
    String USER_UPDATE_TOPIC = "USER_SERVICE.USER.UPDATED.V1";
    String USER_CREATE_TOPIC = "USER_SERVICE.USER.CREATED.V1";

}
