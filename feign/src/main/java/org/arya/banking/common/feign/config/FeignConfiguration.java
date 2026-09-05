package org.arya.banking.common.feign.config;

import feign.codec.ErrorDecoder;
import org.arya.banking.common.feign.exception.FeignClientErrorDecoder;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration extends FeignClientProperties.FeignClientConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignClientErrorDecoder();
    }
}
