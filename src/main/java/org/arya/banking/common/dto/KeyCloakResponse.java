package org.arya.banking.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Generic Keycloak operation response")
public record KeyCloakResponse(
        @Schema(description = "HTTP status code", example = "201")
        String statusCode,
        @Schema(description = "Status message", example = "User created successfully")
        String statusMessage) {
}
