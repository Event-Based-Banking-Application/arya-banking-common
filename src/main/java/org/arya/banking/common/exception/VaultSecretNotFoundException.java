package org.arya.banking.common.exception;

import static org.arya.banking.common.exception.ExceptionCode.VAULT_SECRET_NOT_FOUND_EXCEPTION_404;
import static org.arya.banking.common.exception.ExceptionConstants.NOT_FOUND_ERROR_CODE;

public class VaultSecretNotFoundException extends GlobalException {

    public VaultSecretNotFoundException(String message) {
        super(NOT_FOUND_ERROR_CODE, VAULT_SECRET_NOT_FOUND_EXCEPTION_404, message);
    }
}
