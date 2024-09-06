package com.bootcamp2024.UserMicroservice.domain.api;

import com.bootcamp2024.UserMicroservice.domain.model.Role;

public interface IRoleServicePort {
    Role getRole(String roleName);
}
