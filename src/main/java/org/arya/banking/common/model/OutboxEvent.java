package org.arya.banking.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@SuperBuilder
public abstract class OutboxEvent {

    @Id
    private String id;

    private String aggregateId;

    private String eventType;

    private String payload;

    private String topic;

    private OutboxStatus outboxStatus;

    private int retryCount;
}
