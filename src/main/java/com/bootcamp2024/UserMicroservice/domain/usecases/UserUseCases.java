package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.api.IUserServicePort;
import com.bootcamp2024.UserMicroservice.domain.exception.UserAlreadyExistException;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IUserPersistencePort;


public class UserUseCases implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;


    public UserUseCases(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveWareHouseAssistantUser(User user) {
        if(userPersistencePort.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistException();
        }



        userPersistencePort.saveWareHouseAssistantUser(user);

    }


}
