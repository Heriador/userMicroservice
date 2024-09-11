package com.bootcamp2024.UserMicroservice.domain.exception;

public class IdentityDocumentValidationException extends RuntimeException {
    public IdentityDocumentValidationException(String message) {
        super(message);
    }
}
