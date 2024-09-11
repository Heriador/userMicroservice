package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.api.IUserServicePort;
import com.bootcamp2024.UserMicroservice.domain.exception.UserAlreadyExistException;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IUserPersistencePort;
import com.bootcamp2024.UserMicroservice.domain.util.UserValidator;


public class UserUseCases implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;


    public UserUseCases(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveWareHouseAssistantUser(User user) {
        if(Boolean.TRUE.equals(userPersistencePort.existsByEmail(user.getEmail()))){
            throw new UserAlreadyExistException();
        }

        UserValidator.validate(user);


        userPersistencePort.saveWareHouseAssistantUser(user);

    }


}
