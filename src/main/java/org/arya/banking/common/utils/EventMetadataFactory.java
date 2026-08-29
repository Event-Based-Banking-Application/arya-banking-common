package org.arya.banking.common.utils;

import org.arya.banking.common.avro.EventMetadata;

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
