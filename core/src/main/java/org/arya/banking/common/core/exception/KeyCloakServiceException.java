package org.arya.banking.common.core.exception;

public class KeyCloakServiceException extends GlobalException {

    public KeyCloakServiceException(int httpErrorCode, String errorCode, String errorMessage) {
        super(httpErrorCode, errorCode, errorMessage);
    }
}
