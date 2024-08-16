package com.ms.user.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class HandleException {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
                
        log.error("Business exception:\n{}" + ex.getMessage());
        
        return ResponseEntity.badRequest().body("Business exception : " + ex.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<List<String>> handleUnknownException(Exception ex) {
                
        log.error("Unknown exception:\n{}" + ex.getMessage());
        
        return ResponseEntity.internalServerError().build();
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getObjectName() + " : " + err.getField() + " : " + err.getDefaultMessage())
                .toList();
        
        log.error("Validation error(s):\n{}" + errors);
        
        return ResponseEntity.badRequest().body(errors);
    }
}
