package org.arya.banking.common.aop;

import org.arya.banking.common.utils.EventContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventContextAop {

    @After("@annotation(org.springframework.kafka.annotation.KafkaListener)")
    public void clearEventContext() {
        EventContext.remove();
    }
}
