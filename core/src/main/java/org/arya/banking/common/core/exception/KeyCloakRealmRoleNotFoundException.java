package org.arya.banking.common.core.exception;

import static org.arya.banking.common.core.exception.ExceptionCode.ADMIN_KEYCLOAK_REALM_ROLE_NOT_FOUND_404;
import static org.arya.banking.common.core.exception.ExceptionConstants.NOT_FOUND_ERROR_CODE;

public class KeyCloakRealmRoleNotFoundException extends GlobalException {

    public KeyCloakRealmRoleNotFoundException(String errorMessage) {
        super(NOT_FOUND_ERROR_CODE, ADMIN_KEYCLOAK_REALM_ROLE_NOT_FOUND_404, errorMessage);
    }
}
