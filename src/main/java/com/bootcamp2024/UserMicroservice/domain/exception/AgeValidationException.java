package com.bootcamp2024.UserMicroservice.domain.exception;

public class AgeValidationException extends RuntimeException {
    public AgeValidationException(String message) {
        super(message);
    }
}
