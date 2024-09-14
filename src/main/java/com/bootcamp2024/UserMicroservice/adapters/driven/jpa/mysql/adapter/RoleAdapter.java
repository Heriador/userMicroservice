package com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.adapter;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.mapper.IRoleEntityMapper;
import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.repository.IRoleRepository;
import com.bootcamp2024.UserMicroservice.domain.model.Role;
import com.bootcamp2024.UserMicroservice.domain.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class RoleAdapter implements IRolePersistencePort {

    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Override
    public Role findByName(String roleName) {
        RoleEntity roleEntity = roleRepository.findByName(roleName);

        return roleEntityMapper.toRole(roleEntity);
    }

}
