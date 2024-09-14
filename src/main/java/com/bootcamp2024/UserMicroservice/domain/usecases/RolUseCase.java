package com.bootcamp2024.UserMicroservice.domain.usecases;

import com.bootcamp2024.UserMicroservice.domain.api.IRoleServicePort;
import com.bootcamp2024.UserMicroservice.domain.spi.IRolePersistencePort;

public class RolUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolPersistencePort;

    public RolUseCase(IRolePersistencePort rolPersistencePort) {
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public Long getRoleId(String roleName) {

        return rolPersistencePort.getRoleId(roleName);
    }
}
