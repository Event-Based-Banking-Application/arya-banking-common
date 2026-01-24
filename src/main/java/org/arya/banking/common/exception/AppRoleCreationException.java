package org.arya.banking.common.exception;

import static org.arya.banking.common.exception.ExceptionCode.ADMIN_VAULT_APPROLE_CREATION_EXCEPTION_400;
import static org.arya.banking.common.exception.ExceptionConstants.FORBIDDEN_ERROR_CODE;

public class AppRoleCreationException extends GlobalException {

    public AppRoleCreationException(String message) {
        super(FORBIDDEN_ERROR_CODE, ADMIN_VAULT_APPROLE_CREATION_EXCEPTION_400, message );
    }
}
