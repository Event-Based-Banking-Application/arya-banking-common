package org.arya.banking.common.exception;

import static org.arya.banking.common.exception.ExceptionCode.ADMIN_KEYCLOAK_REALM_ROLE_NOT_FOUND_404;
import static org.arya.banking.common.exception.ExceptionConstants.NOT_FOUND_ERROR_CODE;

public class KeyCloakRealmRoleNotFoundException extends GlobalException {

    public KeyCloakRealmRoleNotFoundException(String errorMessage) {
        super(NOT_FOUND_ERROR_CODE, ADMIN_KEYCLOAK_REALM_ROLE_NOT_FOUND_404, errorMessage);
    }
}
