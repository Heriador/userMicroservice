package com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.mapper;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IRoleEntityMapper.class})
public interface IUserEntityMapper {



    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "identityDocument", target = "identityDocument")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "role", target = "role")
    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);

}
