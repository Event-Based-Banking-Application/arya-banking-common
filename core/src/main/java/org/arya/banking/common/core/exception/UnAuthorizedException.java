package org.arya.banking.common.core.exception;

import static org.arya.banking.common.core.exception.ExceptionCode.ADMIN_UN_AUTHORIZED_EXCEPTION_403;
import static org.arya.banking.common.core.exception.ExceptionConstants.FORBIDDEN_ERROR_CODE;

public class UnAuthorizedException extends GlobalException {

    public UnAuthorizedException(String errorMessage) {
        super(FORBIDDEN_ERROR_CODE, ADMIN_UN_AUTHORIZED_EXCEPTION_403, errorMessage);
    }
}
