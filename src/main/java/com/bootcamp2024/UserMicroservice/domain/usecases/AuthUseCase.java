package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.api.IAuthServicePort;
import com.bootcamp2024.UserMicroservice.domain.exception.AuthenticationException;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IAuthPersistencePort;
import com.bootcamp2024.UserMicroservice.domain.util.UserValidatorConstants;


public class AuthUseCase implements IAuthServicePort {

    private final IAuthPersistencePort authPersistencePort;

    public AuthUseCase(IAuthPersistencePort authPersistencePort) {
        this.authPersistencePort = authPersistencePort;
    }

    @Override
    public String login(String email, String password) {

        if(!authPersistencePort.validateCredentials(email, password)){
            throw new AuthenticationException(UserValidatorConstants.INVALID_CREDENTIALS_MESSAGE);
        }

        User user  = authPersistencePort.authenticate(email, password);

        return authPersistencePort.generateToken(user);


    }
}
