package org.arya.banking.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMehodArgumentNotValidException(MethodArgumentNotValidException ex) {

        return new ResponseEntity<>(new ErrorResponse("403", ex.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleGlobalExceptions(GlobalException globalException) {

        return new ResponseEntity<ErrorResponse>(new ErrorResponse(
            globalException.getErrorCode(), globalException.getErrorMessage()), 
            HttpStatusCode.valueOf(globalException.getHttpErrorCode()));
    }
    
}
