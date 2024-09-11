package com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.util.CreateUserValidationConstants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {

    @NotBlank(message = CreateUserValidationConstants.NAME_NOT_BLANK_MESSAGE)
    @Size(min = CreateUserValidationConstants.NAME_MIN_SIZE, max = CreateUserValidationConstants.NAME_MAX_SIZE)
    private String name;

    @NotBlank(message = CreateUserValidationConstants.LAST_NAME_NOT_BLANK_MESSAGE)
    @Size(min = CreateUserValidationConstants.LAST_NAME_MIN_SIZE, max = CreateUserValidationConstants.LAST_NAME_MAX_SIZE)
    private String lastName;

    @NotBlank(message = CreateUserValidationConstants.IDENTITY_DOCUMENT_NOT_BLANK_MESSAGE)
    @Pattern(regexp = CreateUserValidationConstants.IDENTITY_DOCUMENT_PATTERN, message = CreateUserValidationConstants.IDENTITY_DOCUMENT_NOT_IN_PATTERN_MESSAGE)
    private String identityDocument;

    @NotBlank(message = CreateUserValidationConstants.PHONE_NOT_BLANK_MESSAGE)
    @Pattern(regexp = CreateUserValidationConstants.PHONE_PATTERN, message = CreateUserValidationConstants.PHONE_NOT_IN_PATTERN_MESSAGE)
    private String phone;

    @NotBlank(message = CreateUserValidationConstants.EMAIL_NOT_BLANK_MESSAGE)
    @Email(message = CreateUserValidationConstants.EMAIL_NOT_IN_PATTERN_MESSAGE)
    private String email;

    @NotBlank(message = CreateUserValidationConstants.PASSWORD_NOT_BLANK_MESSAGE)
    @Size(min = CreateUserValidationConstants.PASSWORD_MIN_SIZE, max = CreateUserValidationConstants.PASSWORD_MAX_SIZE)
    private String password;

    @NotBlank(message = CreateUserValidationConstants.BIRTHDATE_NOT_BLANK_MESSAGE)
    @Pattern(regexp = CreateUserValidationConstants.BIRTHDATE_REGEX, message = CreateUserValidationConstants.BIRTHDATE_NOT_IN_PATTERN_MESSAGE)
    private String birthDate;

}
