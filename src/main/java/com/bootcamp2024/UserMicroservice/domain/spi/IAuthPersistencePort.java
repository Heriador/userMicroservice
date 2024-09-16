package com.bootcamp2024.UserMicroservice.domain.spi;

import com.bootcamp2024.UserMicroservice.domain.model.User;

public interface IAuthPersistencePort {
    User authenticate(String email, String password);

    boolean validateCredentials(String email, String password);

    String generateToken(User user);
}
