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

        commonUserFunc(user);

        user.setRoleId(rolePersistencePort.getRoleId(RoleConstant.WAREHOUSE_ASSISTANT.toString()));

        userPersistencePort.saveUser(user);

    }

    @Override
    public void saveClientUser(User user) {

        commonUserFunc(user);

        user.setRoleId(rolePersistencePort.getRoleId(RoleConstant.CLIENT.toString()));

        userPersistencePort.saveUser(user);
    }

    private void commonUserFunc(User user){
        if(userPersistencePort.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistException();
        }

        UserValidator.validate(user);
        user.setPassword(encryptionServicePort.encode(user.getPassword()));

    }
}
