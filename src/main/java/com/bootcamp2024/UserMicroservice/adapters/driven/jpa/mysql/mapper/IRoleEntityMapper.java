package com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.mapper;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.bootcamp2024.UserMicroservice.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IRoleEntityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    Role toRole(RoleEntity roleEntity);
    RoleEntity toRoleEntity(Role role);

}
