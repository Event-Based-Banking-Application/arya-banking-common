package org.arya.banking.common.kafka.utils;

import org.arya.banking.common.avro.EventMetadata;
import org.arya.banking.common.core.utils.EventContext;

import java.util.UUID;

public class EventMetadataFactory {

    private EventMetadataFactory() {}

    public static EventMetadata newEventMetadata() {

        return EventMetadata.newBuilder()
                .setCorrelationId(EventContext.getCorrelationId())
                .setEventId(newEventId())
                .setCausationId(null)
                .build();
    }

    public static EventMetadata causedByMetadata() {

        return EventMetadata.newBuilder()
                .setCorrelationId(EventContext.getCorrelationId())
                .setEventId(newEventId())
                .setCausationId(EventContext.getCausedEventId())
                .build();
    }

    private static CharSequence newEventId() {
        return UUID.randomUUID().toString();
    }
}
