package com.bootcamp2024.UserMicroservice.adapters.driving.http.util;

public class CreateUserValidationConstants {

    public static final int NAME_MIN_SIZE = 2;
    public static final int NAME_MAX_SIZE = 50;
    public static final int LAST_NAME_MIN_SIZE = 2;
    public static final int LAST_NAME_MAX_SIZE = 50;
    public static final int PASSWORD_MIN_SIZE = 8;
    public static final int PASSWORD_MAX_SIZE = 20;


    public static final String NAME_NOT_BLANK_MESSAGE = "Name cannot be blank";
    public static final String LAST_NAME_NOT_BLANK_MESSAGE = "Last name cannot be blank";
    public static final String IDENTITY_DOCUMENT_NOT_BLANK_MESSAGE = "Identity document cannot be blank";
    public static final String IDENTITY_DOCUMENT_NOT_IN_PATTERN_MESSAGE = "Identity document must be a number";
    public static final String PHONE_NOT_IN_PATTERN_MESSAGE = "Phone number must contain a maximum of 13 digits and can contain a + at the beginning";
    public static final String BIRTHDATE_NOT_IN_PATTERN_MESSAGE = "Birthdate must be in the format dd/mm/yyyy";
    public static final String BIRTHDATE_NOT_BLANK_MESSAGE = "Birthdate cannot be blank";
    public static final String EMAIL_NOT_BLANK_MESSAGE = "Email cannot be blank";
    public static final String EMAIL_NOT_IN_PATTERN_MESSAGE = "Email must be valid";
    public static final String PASSWORD_NOT_BLANK_MESSAGE = "Password cannot be blank";
    public static final String PHONE_NOT_BLANK_MESSAGE = "Phone cannot be blank";


    public static final String IDENTITY_DOCUMENT_PATTERN = "^\\d+$";
    public static final String PHONE_PATTERN = "^\\+?[\\d+]{1,13}$";
    public static final String BIRTHDATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";

    private CreateUserValidationConstants(){
        throw new IllegalStateException("Utility class");
    }
    }
