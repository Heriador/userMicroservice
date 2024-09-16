package com.bootcamp2024.UserMicroservice.adapters.driving.http.mapper;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface IUserRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roleId", ignore = true)
    @Mapping(source = "birthDate", target = "birthDate", qualifiedByName = "stringToLocalDate")
    User toUser(CreateUser createUser);

    @Named("stringToLocalDate")
    default LocalDate stringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
