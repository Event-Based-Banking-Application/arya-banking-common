package org.arya.banking.common.exception;

import static org.arya.banking.common.exception.ExceptionCode.ADMIN_KEYCLOAK_REALM_ROLE_ALREADY_EXISTS_409;
import static org.arya.banking.common.exception.ExceptionConstants.CONFLICT_ERROR_CODE;

public class KeyCloakRealmRoleAlreadyExists extends GlobalException {

    public KeyCloakRealmRoleAlreadyExists(String errorMessage) {
        super(CONFLICT_ERROR_CODE, ADMIN_KEYCLOAK_REALM_ROLE_ALREADY_EXISTS_409, errorMessage);
    }
}
