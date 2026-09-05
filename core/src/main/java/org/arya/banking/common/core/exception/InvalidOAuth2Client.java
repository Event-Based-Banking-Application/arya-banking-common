package org.arya.banking.common.core.exception;

public class InvalidOAuth2Client extends GlobalException {

    public InvalidOAuth2Client(int httpErrorCode, String errorCode, String errorMessage) {
        super(httpErrorCode, errorCode, errorMessage);
    }
}
