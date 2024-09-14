package com.bootcamp2024.UserMicroservice.configuration.exceptionConfiguration;

import com.bootcamp2024.UserMicroservice.domain.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.bootcamp2024.UserMicroservice.configuration.util.AuthenticationConstants.*;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleUserAlreadyExistException(UserAlreadyExistException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(String.format(USER_ALREADY_EXISTS_EXCEPTION_MESSAGE),HttpStatus.CONFLICT.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException(AuthenticationException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(String.format(ex.getMessage()),HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(AgeValidationException.class)
    public ResponseEntity<ExceptionResponse> handleAgeValidationException(AgeValidationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(String.format(ex.getMessage()),HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(PhoneValidationException.class)
    public ResponseEntity<ExceptionResponse> handlePhoneValidationException(PhoneValidationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(String.format(ex.getMessage()),HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(EmailValidationException.class)
    public ResponseEntity<ExceptionResponse> handleEmailValidationException(EmailValidationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(String.format(ex.getMessage()),HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(IdentityDocumentValidationException.class)
    public ResponseEntity<ExceptionResponse> handleIdentityDocumentValidationException(IdentityDocumentValidationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(String.format(ex.getMessage()),HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->

                errors.put(error.getField(),error.getDefaultMessage())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }



}
