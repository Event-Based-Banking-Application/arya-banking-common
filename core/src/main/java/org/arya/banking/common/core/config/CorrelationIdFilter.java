package org.arya.banking.common.core.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.arya.banking.common.core.utils.EventContext;
import org.springframework.lang.NonNull;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

import static org.arya.banking.common.core.constants.CorrelationConstants.CORRELATION_ID_HEADER;
import static org.arya.banking.common.core.constants.CorrelationConstants.CORRELATION_MDC_KEY;

@Slf4j
public class CorrelationIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        String correlationId = request.getHeader(CORRELATION_ID_HEADER);
        if (null == correlationId || correlationId.isBlank()) {
            correlationId = UUID.randomUUID().toString();
        }

        EventContext.setCorrelationId(correlationId);
        response.addHeader(CORRELATION_ID_HEADER, correlationId);

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(CORRELATION_MDC_KEY);
        }
    }
}
