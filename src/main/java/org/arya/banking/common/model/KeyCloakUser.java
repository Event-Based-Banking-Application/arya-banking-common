package org.arya.banking.common.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KeyCloakUser {

    private String username;

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;
}
