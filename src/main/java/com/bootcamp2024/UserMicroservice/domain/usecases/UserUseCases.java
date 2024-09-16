package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.api.IEncryptionServicePort;
import com.bootcamp2024.UserMicroservice.domain.api.IUserServicePort;
import com.bootcamp2024.UserMicroservice.domain.exception.UserAlreadyExistException;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import com.bootcamp2024.UserMicroservice.domain.spi.IRolePersistencePort;
import com.bootcamp2024.UserMicroservice.domain.spi.IUserPersistencePort;
import com.bootcamp2024.UserMicroservice.domain.util.RoleConstant;
import com.bootcamp2024.UserMicroservice.domain.util.UserValidator;


public class UserUseCases implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IEncryptionServicePort encryptionServicePort;
    private final IRolePersistencePort rolePersistencePort;


    public UserUseCases(IUserPersistencePort userPersistencePort,
                        IEncryptionServicePort encryptionServicePort,
                        IRolePersistencePort rolePersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.encryptionServicePort = encryptionServicePort;
        this.rolePersistencePort = rolePersistencePort;

    }

    @Override
    public void saveWareHouseAssistantUser(User user) {
        if(Boolean.TRUE.equals(userPersistencePort.existsByEmail(user.getEmail()))){
            throw new UserAlreadyExistException();
        }

        UserValidator.validate(user);
        user.setId(rolePersistencePort.getRoleId(RoleConstant.WAREHOUSE_ASSISTANT.toString()));
        user.setPassword(encryptionServicePort.encode(user.getPassword()));


        userPersistencePort.saveWareHouseAssistantUser(user);

    }


}
