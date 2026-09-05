package org.arya.banking.common.core.exception;

import static org.arya.banking.common.core.exception.ExceptionCode.ADMIN_VAULT_APPROLE_CREATION_EXCEPTION_400;
import static org.arya.banking.common.core.exception.ExceptionConstants.FORBIDDEN_ERROR_CODE;

public class AppRoleCreationException extends GlobalException {

    public AppRoleCreationException(String message) {
        super(FORBIDDEN_ERROR_CODE, ADMIN_VAULT_APPROLE_CREATION_EXCEPTION_400, message );
    }
}
