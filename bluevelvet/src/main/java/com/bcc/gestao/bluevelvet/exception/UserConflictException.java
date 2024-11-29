package com.bcc.gestao.bluevelvet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserConflictException extends RuntimeException {

    public UserConflictException() {
    }

    public UserConflictException(String message) {
        super(message);
    }
}
