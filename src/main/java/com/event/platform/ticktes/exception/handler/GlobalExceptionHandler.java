package com.event.platform.ticktes.exception.handler;

import com.event.platform.ticktes.exception.base.BaseException;
import com.event.platform.ticktes.exception.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException ( BaseException ex ){
        log.error("caught BaseException",ex);
        ErrorResponse respone = new ErrorResponse("Faild", HttpStatus.NOT_FOUND.value(),"Base Exception");
        return new ResponseEntity<>(respone,HttpStatus.NOT_FOUND);
    }
}
