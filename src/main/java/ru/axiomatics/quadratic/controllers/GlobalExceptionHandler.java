package ru.axiomatics.quadratic.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.axiomatics.quadratic.controllers.exceptions.DiscriminantLessZeroException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = DiscriminantLessZeroException.class)
    public ResponseEntity<Object> discriminantLessZero(DiscriminantLessZeroException discriminantLessZeroException,
                                                       WebRequest webRequest) {
        return ResponseEntity.badRequest().body(discriminantLessZeroException.getMessage());
    }
}
