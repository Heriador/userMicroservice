package com.bootcamp2024.UserMicroservice.domain.spi;

import com.bootcamp2024.UserMicroservice.domain.model.Role;

public interface IRolePersistencePort {
    Role findByName(String roleName);
}
