package com.bcc.gestao.bluevelvet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CredentialAuthenticationException extends RuntimeException {

    public CredentialAuthenticationException() {
    }

    public CredentialAuthenticationException(String message) {
        super(message);
    }
}
