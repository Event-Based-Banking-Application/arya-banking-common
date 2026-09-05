package org.arya.banking.common.core.exception;

public class SecurityDetailsNotFoundException extends GlobalException {

    public SecurityDetailsNotFoundException(int httpErrorCode, String errorCode, String errorMessage) {
        super(httpErrorCode, errorCode, errorMessage);
    }
}
