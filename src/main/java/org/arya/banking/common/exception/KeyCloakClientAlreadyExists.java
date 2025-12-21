package org.arya.banking.common.exception;

public class KeyCloakClientAlreadyExists extends GlobalException {

    public KeyCloakClientAlreadyExists(int httpErrorCode, String errorCode, String errorMessage) {
        super(httpErrorCode, errorCode, errorMessage);
    }
}
