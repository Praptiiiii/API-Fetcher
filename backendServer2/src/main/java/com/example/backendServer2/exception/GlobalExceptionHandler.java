package com.example.backendServer2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * The {@code GlobalExceptionHandler} class serves as a centralized exception handler for the backend server,
 * providing a consistent way to handle validation and general exceptions across different controllers.
 * It is annotated with {@code @RestControllerAdvice}, indicating that it applies to all controllers in the application.
 *
 * The class includes a method annotated with {@code @ExceptionHandler} to handle exceptions of type
 * {@code MethodArgumentNotValidException} and {@code IllegalArgumentException}. It returns a {@code ResponseEntity}
 * with an appropriate HTTP status code and a message describing the nature of the exception. Additionally, it catches
 * any other exceptions and responds with a generic internal server error message.
 *
 * @author prapti
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation exceptions, such as {@code MethodArgumentNotValidException} and {@code IllegalArgumentException}.
     * Returns a {@code ResponseEntity} with a BAD_REQUEST status and a message describing the nature of the validation error.
     *
     * @param ex The exception to be handled.
     * @return A {@code ResponseEntity} containing the error message and appropriate HTTP status.
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
