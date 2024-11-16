package com.bcc.gestao.bluevelvet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductConflictException extends RuntimeException {

    public ProductConflictException() {
        super("Product conflict occurred");
    }

    public ProductConflictException(String message) {
        super(message);
    }
}
