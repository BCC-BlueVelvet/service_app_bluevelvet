package com.bcc.gestao.bluevelvet.exception.handler;

import com.bcc.gestao.bluevelvet.exception.ProductConflictException;
import com.bcc.gestao.bluevelvet.exception.ProductInvalidAttributeException;
import com.bcc.gestao.bluevelvet.exception.ProductNotFoundException;
import com.bcc.gestao.bluevelvet.exception.RoleNotFoundException;
import com.bcc.gestao.bluevelvet.exception.UserConflictException;
import com.bcc.gestao.bluevelvet.exception.UserInvalidException;
import com.bcc.gestao.bluevelvet.exception.UserNotFoundException;
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
    public final ResponseEntity<String> handleProductInvalidAttribute(ProductInvalidAttributeException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
    }

    @ExceptionHandler(UserInvalidException.class)
    public final ResponseEntity<String> handleUserInvalidAttribute(UserInvalidException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
    }

    @ExceptionHandler(ProductConflictException.class)
    public final ResponseEntity<String> handleProductConflict(ProductConflictException exc) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exc.getMessage());
    }

    @ExceptionHandler(UserConflictException.class)
    public final ResponseEntity<String> handleUserConflict(UserConflictException exc) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exc.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<String> handleProductNotFound(ProductNotFoundException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exc.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<String> handleUserNotFound(UserNotFoundException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exc.getMessage());
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public final ResponseEntity<String> handleRoleNotFound(RoleNotFoundException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exc.getMessage());
    }
}
