package com.bcc.gestao.bluevelvet.exception.handler;

import com.bcc.gestao.bluevelvet.exception.ProductConflictException;
import com.bcc.gestao.bluevelvet.exception.ProductInvalidAttributeException;
import com.bcc.gestao.bluevelvet.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class BlueVelvetExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductInvalidAttributeException.class)
    public final ResponseEntity<String> handleInvalidAttribute(ProductInvalidAttributeException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
    }

    @ExceptionHandler(ProductConflictException.class)
    public final ResponseEntity<String> handleConflict(ProductConflictException exc) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exc.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<String> handleNotFound(ProductNotFoundException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exc.getMessage());
    }
}
