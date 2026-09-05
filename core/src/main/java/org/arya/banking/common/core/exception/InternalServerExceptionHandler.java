package org.arya.banking.common.core.exception;

import lombok.Data;

@Data
public class InternalServerExceptionHandler extends RuntimeException {

    private String status;

    private String error;

    private String message;
}
