package org.arya.banking.common.exception;

import static org.arya.banking.common.exception.ExceptionCode.ADMIN_VAULT_SECRET_ID_EXCEPTION_403;
import static org.arya.banking.common.exception.ExceptionConstants.FORBIDDEN_ERROR_CODE;

public class SecretIdNotFoundException extends GlobalException {

    public SecretIdNotFoundException(String message) {
        super(FORBIDDEN_ERROR_CODE, ADMIN_VAULT_SECRET_ID_EXCEPTION_403, message);
    }
}
