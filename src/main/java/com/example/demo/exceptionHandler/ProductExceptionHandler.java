package com.example.demo.exceptionHandler;

import com.example.demo.exception.MerchantCreateException;
import com.example.demo.exception.ProductNotFoundException;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler({ ProductNotFoundException.class })
    public ResponseEntity<String> handleMerchantCreationFailedException(@NotNull ProductNotFoundException productNotFoundException) {
        return new ResponseEntity<>(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
