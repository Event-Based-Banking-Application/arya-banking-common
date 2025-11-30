package org.arya.banking.common.exception;

import static org.arya.banking.common.exception.ExceptionCode.ADMIN_UN_AUTHORIZED_EXCEPTION_403;
import static org.arya.banking.common.exception.ExceptionConstants.FORBIDDEN_ERROR_CODE;

public class UnAuthorizedException extends GlobalException {

    public UnAuthorizedException(String errorMessage) {
        super(FORBIDDEN_ERROR_CODE, ADMIN_UN_AUTHORIZED_EXCEPTION_403, errorMessage);
    }
}
