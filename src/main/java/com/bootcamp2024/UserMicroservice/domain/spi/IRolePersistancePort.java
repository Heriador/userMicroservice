package com.bootcamp2024.UserMicroservice.domain.spi;

import com.bootcamp2024.UserMicroservice.domain.model.Role;

public interface IRolePersistancePort {
    Role findByName(String roleName);
}
