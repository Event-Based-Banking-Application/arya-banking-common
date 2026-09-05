package org.arya.banking.common.kafka.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Aspect.class)
public class EventContextAopAutoConfiguration {

    @Bean
    public EventContextAop eventContextAop() {
        return new EventContextAop();
    }
}
