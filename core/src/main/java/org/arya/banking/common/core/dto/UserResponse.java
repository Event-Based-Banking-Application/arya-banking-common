package org.arya.banking.common.core.dto;

public record UserResponse(
        String userId,
        String response,
        String responseCode) {

}
