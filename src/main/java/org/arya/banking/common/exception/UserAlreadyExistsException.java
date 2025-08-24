package org.arya.banking.common.exception;

public class UserAlreadyExistsException extends GlobalException {

    public UserAlreadyExistsException(int httpErrorCode, String errorCode, String errorMessage) {
        super(httpErrorCode, errorCode, errorMessage);
    }
}
