package com.bank.history.back.handler;

import com.bank.history.back.exception.HistoryBadRequestException;
import com.bank.history.back.exception.HistoryConflictException;
import com.bank.history.back.exception.HistoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(HistoryNotFoundException.class)
    public ResponseEntity<String> handleHistoryNotFoundException(HistoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(HistoryConflictException.class)
    public ResponseEntity<String> handleHistoryConflictException(HistoryConflictException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(HistoryBadRequestException.class)
    public ResponseEntity<String> handleHistoryBadRequestException(HistoryBadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
