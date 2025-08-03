package org.arya.banking.common.exception;

import lombok.Data;

@Data
@lombok.EqualsAndHashCode(callSuper = true)
public class GlobalException extends RuntimeException {

    private int httpErrorCode;

    private String errorCode;

    private String errorMessage;

    public GlobalException(int httpErrorCode, String errorCode, String errorMessage) {
        this.httpErrorCode = httpErrorCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
}
