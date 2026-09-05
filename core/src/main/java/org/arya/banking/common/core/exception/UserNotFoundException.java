package org.arya.banking.common.core.exception;

public class UserNotFoundException extends GlobalException {

    public UserNotFoundException(int httpErrorCode, String errorCode, String errorMessage) {
        super(httpErrorCode, errorCode, errorMessage);
    }
}
