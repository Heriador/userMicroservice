package com.bootcamp2024.UserMicroservice.domain.util;


public class UserValidatorConstants {

    public static final String PHONE_NOT_IN_PATTERN_MESSAGE = "Phone number must contain a maximum of 13 digits and can contain a + at the beginning";
    public static final String IDENTITY_DOCUMENT_NOT_IN_PATTERN_MESSAGE = "Identity document must be a number";
    public static final String EMAIL_NOT_IN_PATTERN_MESSAGE = "Email must be valid";
    public static final String INVALID_AGE_MESSAGE = "User must be at least 18 years old";


    public static final int MINIMUM_AGE = 18;
    public static final String IDENTITY_DOCUMENT_PATTERN = "^\\d+$";
    public static final String PHONE_PATTERN = "^\\+?[\\d+]{1,13}$";
    public static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";


    private UserValidatorConstants(){
    }

}
