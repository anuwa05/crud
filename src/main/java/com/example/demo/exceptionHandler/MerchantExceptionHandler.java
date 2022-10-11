package com.example.demo.exceptionHandler;

import com.example.demo.exception.MerchantCreateException;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MerchantExceptionHandler {

    @ExceptionHandler({ MerchantCreateException.class })
    public ResponseEntity<String> handleMerchantCreationFailedException(@NotNull MerchantCreateException merchantCreateException) {
        return new ResponseEntity<>(merchantCreateException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
