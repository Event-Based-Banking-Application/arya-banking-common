package org.arya.banking.common.config;

import org.arya.banking.common.mapper.DateToLocalDateTimeMapper;
import org.arya.banking.common.mapper.LocalDateTimeToDateMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(
                new LocalDateTimeToDateMapper(),
                new DateToLocalDateTimeMapper()
        ));
    }
}
