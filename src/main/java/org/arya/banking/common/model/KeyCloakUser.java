package org.arya.banking.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Keycloak user representation for user registration in Keycloak")
public class KeyCloakUser {

    @Schema(description = "Keycloak username", example = "johndoe")
    private String username;

    @Schema(description = "First name", example = "John")
    private String firstName;

    @Schema(description = "Last name", example = "Doe")
    private String lastName;

    @Schema(description = "Email address", example = "john.doe@example.com")
    private String emailId;

    @Schema(description = "Initial password", example = "TempP@ss123!")
    private String password;
}
