package com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String name;

    private String lastName;

    private String identityDocument;

    private String phone;

    private String email;

    private String password;

    private LocalDate birthDate;
}
