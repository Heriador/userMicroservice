package com.bootcamp2024.UserMicroservice.factory;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.request.CreateUser;
import com.bootcamp2024.UserMicroservice.adapters.driving.http.dto.response.UserResponse;
import com.bootcamp2024.UserMicroservice.domain.model.User;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class UserFactory {

    private static final User user;

    static {
        user = new User.Builder()
                .id(1L)
                .name("name")
                .lastName("lastName")
                .identityDocument("1457895133657")
                .phone("phone")
                .email("email@gmail.com")
                .password("password")
                .birthDate(LocalDate.of(2001,4,22))
                .role(RoleFactory.getWarehouseAss())
                .phone("+57896145321")
                .build();

    }

    public static User getUser() {
        return user;
    }

    public static CreateUser getCreateUser() {
        CreateUser createUser = new CreateUser();
        createUser.setName(user.getName());
        createUser.setLastName(user.getLastName());
        createUser.setIdentityDocument(user.getIdentityDocument());
        createUser.setPhone(user.getPhone());
        createUser.setEmail(user.getEmail());
        createUser.setPassword(user.getPassword());
        createUser.setBirthDate(user.getBirthDate().toString());

        return createUser;
    }

    public static UserResponse getUserResponse() {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setLastName(user.getLastName());
        userResponse.setIdentityDocument(user.getIdentityDocument());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setBirthDate(user.getBirthDate());

        return userResponse;
    }

    public static UserEntity getUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhone(user.getPhone());
        userEntity.setBirthDate(user.getBirthDate());
        userEntity.setRole(RoleFactory.getWarehouseAssEntity());

        return userEntity;
    }

    public static User userWithInvalidEmail() {
        User userInvalidEmail = new User();
        userInvalidEmail.setId(user.getId());
        userInvalidEmail.setEmail("invalidEmail");
        userInvalidEmail.setPassword(user.getPassword());
        userInvalidEmail.setBirthDate(user.getBirthDate());
        userInvalidEmail.setRole(user.getRole());
        userInvalidEmail.setPhone(user.getPhone());
        userInvalidEmail.setIdentityDocument(user.getIdentityDocument());
        userInvalidEmail.setLastName(user.getLastName());
        userInvalidEmail.setName(user.getName());


        return userInvalidEmail;
    }

    public static User userWithInvalidPhone() {
        User userInvalidPhone = new User();
        userInvalidPhone.setPhone("invalidPhone");
        userInvalidPhone.setPassword(user.getPassword());
        userInvalidPhone.setBirthDate(user.getBirthDate());
        userInvalidPhone.setRole(user.getRole());
        userInvalidPhone.setIdentityDocument(user.getIdentityDocument());
        userInvalidPhone.setLastName(user.getLastName());
        userInvalidPhone.setName(user.getName());
        userInvalidPhone.setEmail(user.getEmail());


        return userInvalidPhone;
    }

    public static User userWithInvalidIdentityDocument() {
        User userInvalidIdentityDocument = new User();
        userInvalidIdentityDocument.setIdentityDocument("invalidIdentityDocument");
        userInvalidIdentityDocument.setPassword(user.getPassword());
        userInvalidIdentityDocument.setBirthDate(user.getBirthDate());
        userInvalidIdentityDocument.setRole(user.getRole());
        userInvalidIdentityDocument.setPhone(user.getPhone());
        userInvalidIdentityDocument.setLastName(user.getLastName());
        userInvalidIdentityDocument.setName(user.getName());
        userInvalidIdentityDocument.setEmail(user.getEmail());

        return userInvalidIdentityDocument;
    }

    public static User userWithInvalidAge() {
        User userInvalidAge = new User();
        userInvalidAge.setBirthDate(LocalDate.now().minusYears(5));
        userInvalidAge.setPassword(user.getPassword());
        userInvalidAge.setRole(user.getRole());
        userInvalidAge.setPhone(user.getPhone());
        userInvalidAge.setIdentityDocument(user.getIdentityDocument());
        userInvalidAge.setLastName(user.getLastName());
        userInvalidAge.setName(user.getName());
        userInvalidAge.setEmail(user.getEmail());




        return userInvalidAge;
    }

}
