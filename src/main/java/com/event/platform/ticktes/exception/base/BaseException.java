package com.event.platform.ticktes.exception.base;

import org.springframework.http.HttpStatus;


public class BaseException extends RuntimeException{
    public BaseException() {
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }
}