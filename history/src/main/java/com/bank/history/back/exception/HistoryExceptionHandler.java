package com.bank.history.back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HistoryExceptionHandler {

    @ExceptionHandler(HistoryException.class)
    public ResponseEntity<String> handleHistoryException(HistoryException exception) {
        HttpStatus status;
        if (exception instanceof HistoryNotFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else if (exception instanceof HistoryBadRequestException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (exception instanceof HistoryConflictException) {
            status = HttpStatus.CONFLICT;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(exception.getMessage(), status);
    }
}