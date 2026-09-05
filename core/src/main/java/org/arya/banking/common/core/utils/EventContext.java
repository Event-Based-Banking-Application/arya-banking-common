package org.arya.banking.common.core.utils;

public class EventContext {

    public static final ThreadLocal<String> CORRELATION_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> CAUSED_EVENT_ID = new ThreadLocal<>();

    private EventContext() {}

    public static void setEventContext(String correlationId, String currentEventId) {
        CORRELATION_ID.set(correlationId);
        CAUSED_EVENT_ID.set(currentEventId);
    }

    public static void setCorrelationId(String correlationId) {
        CORRELATION_ID.set(correlationId);
    }

    public static void setCausedEventId(String causedEventId) {
        CAUSED_EVENT_ID.set(causedEventId);
    }

    public static String getCorrelationId() {
        return CORRELATION_ID.get();
    }

    public static String getCausedEventId() {
        return CAUSED_EVENT_ID.get();
    }

    public static void remove() {
        CORRELATION_ID.remove();
        CAUSED_EVENT_ID.remove();
    }
}
