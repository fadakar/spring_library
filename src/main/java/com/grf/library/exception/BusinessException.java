package com.grf.library.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {

    private HttpStatus httpStatus;

    public BusinessException(String message) {
        super(message);
        this.httpStatus = HttpStatus.OK;
    }

    public BusinessException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
