package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.api.IRoleServicePort;
import com.bootcamp2024.UserMicroservice.domain.model.Role;
import com.bootcamp2024.UserMicroservice.domain.spi.IRolePersistancePort;

public class RolUseCase implements IRoleServicePort {

    private final IRolePersistancePort rolPersistancePort;

    public RolUseCase(IRolePersistancePort rolPersistancePort) {
        this.rolPersistancePort = rolPersistancePort;
    }


    public Role getRole(String roleName) {

        return rolPersistancePort.findByName(roleName);
    }
}
