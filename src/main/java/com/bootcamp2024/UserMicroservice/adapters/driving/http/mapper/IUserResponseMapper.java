package com.bootcamp2024.UserMicroservice.adapters.driving.http.mapper;

import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.UserResponse;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserResponseMapper {

    UserResponse userToUserResponse(User user);


}
