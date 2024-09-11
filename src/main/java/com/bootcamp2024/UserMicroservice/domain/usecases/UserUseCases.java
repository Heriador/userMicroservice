package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.api.IEncryptionServicePort;
import com.bootcamp2024.UserMicroservice.domain.api.IUserServicePort;
import com.bootcamp2024.UserMicroservice.domain.exception.UserAlreadyExistException;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IUserPersistencePort;
import com.bootcamp2024.UserMicroservice.domain.util.UserValidator;


public class UserUseCases implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IEncryptionServicePort encryptionServicePort;


    public UserUseCases(IUserPersistencePort userPersistencePort, IEncryptionServicePort encryptionServicePort) {
        this.userPersistencePort = userPersistencePort;
        this.encryptionServicePort = encryptionServicePort;
    }

    @Override
    public void saveWareHouseAssistantUser(User user) {
        if(Boolean.TRUE.equals(userPersistencePort.existsByEmail(user.getEmail()))){
            throw new UserAlreadyExistException();
        }

        UserValidator.validate(user);

        user.setPassword(encryptionServicePort.encode(user.getPassword()));


        userPersistencePort.saveWareHouseAssistantUser(user);

    }


}
