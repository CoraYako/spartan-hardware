package com.spartanHardware.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<Object> handle(CustomException ex, WebRequest request) {
        String response = ex.getMessage();
        return handleExceptionInternal(ex, response, new HttpHeaders(),ex.getStatusCode(), request);
    }


    protected ResponseEntity<Map<String,String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach( error -> {
                    errorMap.put(ex.getFieldError().getField(), error.getDefaultMessage());
                }
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }
}
