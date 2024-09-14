package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.api.IRoleServicePort;
import com.bootcamp2024.UserMicroservice.domain.model.Role;
import com.bootcamp2024.UserMicroservice.domain.spi.IRolePersistencePort;

public class RolUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolPersistancePort;

    public RolUseCase(IRolePersistencePort rolPersistancePort) {
        this.rolPersistancePort = rolPersistancePort;
    }


    public Role getRole(String roleName) {

        return rolPersistancePort.findByName(roleName);
    }
}
