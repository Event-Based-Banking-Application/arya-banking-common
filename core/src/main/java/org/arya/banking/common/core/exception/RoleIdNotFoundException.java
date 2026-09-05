package org.arya.banking.common.core.exception;

import static org.arya.banking.common.core.exception.ExceptionCode.ADMIN_VAULT_ROLE_ID_EXCEPTION_403;
import static org.arya.banking.common.core.exception.ExceptionConstants.FORBIDDEN_ERROR_CODE;

public class RoleIdNotFoundException extends GlobalException {

    public RoleIdNotFoundException(String message) {
        super(FORBIDDEN_ERROR_CODE, ADMIN_VAULT_ROLE_ID_EXCEPTION_403, message);
    }
}
