package com.bootcamp2024.UserMicroservice.domain.util;

import com.bootcamp2024.UserMicroservice.domain.exception.AgeValidationException;
import com.bootcamp2024.UserMicroservice.domain.exception.EmailValidationException;
import com.bootcamp2024.UserMicroservice.domain.exception.IdentityDocumentValidationException;
import com.bootcamp2024.UserMicroservice.domain.exception.PhoneValidationException;
import com.bootcamp2024.UserMicroservice.domain.model.User;

import java.time.LocalDate;

public class UserValidator {
    private UserValidator(){

    }

    public static void validate(User user){
        validateEmail(user.getEmail());
        validatePhone(user.getPhone());
        validateIdentityDocument(user.getIdentityDocument());
        validateAge(user.getBirthDate());


    }

    public static void validatePhone(String phone){
        if( !phone.matches(UserValidatorConstants.PHONE_PATTERN)){
            throw new PhoneValidationException(UserValidatorConstants.PHONE_NOT_IN_PATTERN_MESSAGE);
        }
    }

    public static void validateIdentityDocument(String identityDocument){
         if(!identityDocument.matches(UserValidatorConstants.IDENTITY_DOCUMENT_PATTERN)){
            throw new IdentityDocumentValidationException(UserValidatorConstants.IDENTITY_DOCUMENT_NOT_IN_PATTERN_MESSAGE);
         }
    }

    public static void validateEmail(String email){
        if(!email.matches(UserValidatorConstants.EMAIL_PATTERN)){
            throw new EmailValidationException(UserValidatorConstants.EMAIL_NOT_IN_PATTERN_MESSAGE);
        }
    }

    public static void validateAge(LocalDate birthDate){
        if(LocalDate.from(birthDate).until(LocalDate.now()).getYears() < UserValidatorConstants.MINIMUM_AGE){
            throw new AgeValidationException(UserValidatorConstants.INVALID_AGE_MESSAGE);
        }
    }

}
