package com.ninggc.multipledb.common.config;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String handException(Exception e) {
        return e.getMessage();
    }
}
