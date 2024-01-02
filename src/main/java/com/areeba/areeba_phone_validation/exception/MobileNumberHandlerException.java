package com.areeba.areeba_phone_validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

 /* MobileNumberHandlerException.java - Intercepts all thrown Exceptions, decides the appropriate Http status
         * message, builds and return an ErrorResponse.*/
@ControllerAdvice
public class MobileNumberHandlerException extends ResponseEntityExceptionHandler {

     @ExceptionHandler(value = { Exception.class })
     protected ResponseEntity<Object> handleGenericException(InvalidMobileNumberException ex, WebRequest request) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
     }
     @ExceptionHandler(value = { InvalidMobileNumberException.class })
     protected ResponseEntity<Object> handleInvalidMobileExceptions(InvalidMobileNumberException ex, WebRequest request) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
     }

}
