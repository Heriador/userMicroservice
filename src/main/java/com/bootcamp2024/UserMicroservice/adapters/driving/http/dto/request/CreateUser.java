package com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.util.UserValidationConstants;
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

    @NotBlank(message = UserValidationConstants.NAME_NOT_BLANK_MESSAGE)
    @Size(min = UserValidationConstants.NAME_MIN_SIZE, max = UserValidationConstants.NAME_MAX_SIZE)
    private String name;

    @NotBlank(message = UserValidationConstants.LAST_NAME_NOT_BLANK_MESSAGE)
    @Size(min = UserValidationConstants.LAST_NAME_MIN_SIZE, max = UserValidationConstants.LAST_NAME_MAX_SIZE)
    private String lastName;

    @NotBlank(message = UserValidationConstants.IDENTITY_DOCUMENT_NOT_BLANK_MESSAGE)
    @Pattern(regexp = UserValidationConstants.IDENTITY_DOCUMENT_PATTERN, message = UserValidationConstants.IDENTITY_DOCUMENT_NOT_IN_PATTERN_MESSAGE)
    private String identityDocument;

    @NotBlank(message = UserValidationConstants.PHONE_NOT_BLANK_MESSAGE)
    @Pattern(regexp = UserValidationConstants.PHONE_PATTERN, message = UserValidationConstants.PHONE_NOT_IN_PATTERN_MESSAGE)
    private String phone;

    @NotBlank(message = UserValidationConstants.EMAIL_NOT_BLANK_MESSAGE)
    @Email(message = UserValidationConstants.EMAIL_NOT_IN_PATTERN_MESSAGE)
    private String email;

    @NotBlank(message = UserValidationConstants.PASSWORD_NOT_BLANK_MESSAGE)
    @Size(min = UserValidationConstants.PASSWORD_MIN_SIZE, max = UserValidationConstants.PASSWORD_MAX_SIZE)
    private String password;

    @NotBlank(message = UserValidationConstants.BIRTHDATE_NOT_BLANK_MESSAGE)
    @Pattern(regexp = UserValidationConstants.BIRTHDATE_REGEX, message = UserValidationConstants.BIRTHDATE_NOT_IN_PATTERN_MESSAGE)
    private String birthDate;

}
