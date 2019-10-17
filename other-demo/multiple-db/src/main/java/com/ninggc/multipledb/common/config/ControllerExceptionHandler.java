package com.ninggc.multipledb.common.config;

import com.ninggc.common.web.ResponseData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 标记是对controller的advice
@RestControllerAdvice
public class ControllerExceptionHandler {
    // 标记匹配的异常
    @ExceptionHandler(value = Exception.class)
    public ResponseData<Object> handException(Exception e) {
        // 在这里可以对相应的异常进行封装
        return ResponseData.buildFailed(e.getMessage());
    }
}
