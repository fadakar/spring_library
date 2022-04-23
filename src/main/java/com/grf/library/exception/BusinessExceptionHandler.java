package com.grf.library.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BusinessExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleConflict(BusinessException ex, WebRequest request) {
        return new ResponseEntity<Object>(" [  Fadakar  ] " + ex.getMessage(), ex.getHttpStatus());
    }
}
