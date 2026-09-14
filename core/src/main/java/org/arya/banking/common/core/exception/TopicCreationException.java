package org.arya.banking.common.core.exception;

public class TopicCreationException extends GlobalException {

    public TopicCreationException(int httpErrorCode, String errorCode, String errorMessage) {
        super(httpErrorCode, errorCode, errorMessage);
    }
}
