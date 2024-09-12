package com.bootcamp2024.UserMicroservice.configuration.util;

public class ErrorConstants {

    private ErrorConstants() {
        throw new IllegalStateException("utility class");
    }

    public static final String USER_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The user you want to create already exists";

}
