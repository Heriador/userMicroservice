package com.bootcamp2024.UserMicroservice.domain.exception;

public class PhoneValidationException extends RuntimeException {
    public PhoneValidationException(String message) {
        super(message);
    }
}
