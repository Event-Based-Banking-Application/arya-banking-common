package org.arya.banking.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User operation response")
public record UserResponse(
        @Schema(description = "Unique user identifier", example = "usr_abc123def456")
        String userId,
        @Schema(description = "Response message", example = "User registered successfully")
        String response,
        @Schema(description = "Response code", example = "200")
        String responseCode) {

}
