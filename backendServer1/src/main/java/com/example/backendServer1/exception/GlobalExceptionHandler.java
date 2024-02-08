package com.example.backendServer1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The {@code GlobalExceptionHandler} class serves as a central point to handle global exceptions in the backend server.
 * It uses Spring's {@code RestControllerAdvice} annotation to provide centralized exception handling across all
 * controllers. This class includes methods to handle specific exceptions like {@code MethodArgumentNotValidException}
 * and {@code IllegalArgumentException} and returns appropriate HTTP responses with error messages.
 *
 * @author prapti
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions related to validation errors, such as when input arguments fail validation.
     *
     * @param ex The {@code MethodArgumentNotValidException} or {@code IllegalArgumentException} that occurred.
     * @return A {@code ResponseEntity} with a BAD_REQUEST status and an error message describing the validation failure.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, IllegalArgumentException.class})
    public ResponseEntity<String> handleValidationExceptions(Exception ex) {
        if (ex instanceof MethodArgumentNotValidException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid input: " + ((MethodArgumentNotValidException) ex).getBindingResult().getFieldError().getDefaultMessage());
        } else if (ex instanceof IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + ex.getMessage());
        }

        // If an unknown exception occurs, return an internal server error response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
}
