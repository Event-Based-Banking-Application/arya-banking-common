package org.arya.banking.common.kafka.aop;

import org.arya.banking.common.core.utils.EventContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EventContextAop {

    @After("@annotation(org.springframework.kafka.annotation.KafkaListener)")
    public void clearEventContext() {
        EventContext.remove();
    }
}
