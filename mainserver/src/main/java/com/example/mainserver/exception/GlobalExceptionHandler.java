package com.example.mainserver.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The {@code GlobalExceptionHandler} class is a centralized exception handler for handling exceptions globally
 * in the backend server3 application. It is annotated with {@code @RestControllerAdvice} to indicate that it provides
 * global exception handling advice for RESTful controllers.
 *
 * This class contains a method annotated with {@code @ExceptionHandler} to handle exceptions of type
 * {@code MethodArgumentNotValidException} and {@code IllegalArgumentException}. In case of validation errors or
 * invalid arguments, it returns a {@code ResponseEntity} with an appropriate HTTP status code (BAD_REQUEST) and a
 * corresponding error message. For other types of exceptions, it returns a response with an HTTP status code of
 * INTERNAL_SERVER_ERROR and a generic error message.
 *
 * @author prapti
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions of type {@code MethodArgumentNotValidException} and {@code IllegalArgumentException}.
     * In case of validation errors or invalid arguments, it returns a {@code ResponseEntity} with an appropriate
     * HTTP status code (BAD_REQUEST) and a corresponding error message. For other types of exceptions, it returns
     * a response with an HTTP status code of INTERNAL_SERVER_ERROR and a generic error message.
     *
     * @param ex The exception to be handled.
     * @return A {@code ResponseEntity} containing the error message and HTTP status code.
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

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
}

