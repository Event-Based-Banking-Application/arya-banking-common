package org.arya.banking.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMehodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() +": "+fieldError.getDefaultMessage())
                .toList();

        return new ResponseEntity<>(new ErrorResponse("403", errors.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleGlobalExceptions(GlobalException globalException) {

        return new ResponseEntity<ErrorResponse>(new ErrorResponse(
            globalException.getErrorCode(), globalException.getErrorMessage()), 
            HttpStatusCode.valueOf(globalException.getHttpErrorCode()));
    }
    
}
