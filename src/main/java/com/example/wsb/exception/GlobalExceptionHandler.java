package com.example.wsb.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidExxception(MethodArgumentNotValidException exc){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto(exc.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList())
        );
    }

    public static record ErrorDto(List<String> messages){};
}
