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
    public Long getRoleId(String roleName) {
        RoleEntity roleEntity = roleRepository.findByName(roleName);

        return roleEntity.getId();
    }

    @Override
    public Role getRoleName(Long roleId) {
        RoleEntity roleEntity = roleRepository.findById(roleId).orElseThrow();

        return roleEntityMapper.toRole(roleEntity);
    }
}
