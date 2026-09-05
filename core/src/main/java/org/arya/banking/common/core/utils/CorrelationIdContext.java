package org.arya.banking.common.core.utils;

import org.slf4j.MDC;

import static org.arya.banking.common.core.constants.CorrelationConstants.CORRELATION_MDC_KEY;

public class CorrelationIdContext {

    private CorrelationIdContext() {}

    public static void set(String correlationId) {
        MDC.put(CORRELATION_MDC_KEY, correlationId);
    }

    public static String get() {
        return MDC.get(CORRELATION_MDC_KEY);
    }
}
