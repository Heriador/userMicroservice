package com.bootcamp2024.UserMicroservice.configuration.util;

public class AuthenticationConstants {

    private AuthenticationConstants() {
        throw new IllegalStateException("utility class");
    }

    public static final String USER_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The user you want to create already exists";
    public static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User not found, incorrect email or password";
    public static final String INVALID_CREDENTIALS_EXCEPTION_MESSAGE = "Invalid credentials";
    public static final String INVALID_TOKEN_MESSAGE = "Invalid token";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";

}
