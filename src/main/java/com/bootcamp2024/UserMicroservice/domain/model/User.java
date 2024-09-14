package com.bootcamp2024.UserMicroservice.domain.model;


import java.time.LocalDate;

public class User {

    private Long id;
    private String name;
    private String lastName;
    private String identityDocument;
    private String phone;
    private String email;
    private String password;
    private LocalDate birthDate;
    private Long roleId;

    public User(){

    }

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.identityDocument = builder.identityDocument;
        this.phone = builder.phone;
        this.email = builder.email;
        this.password = builder.password;
        this.birthDate = builder.birthDate;
        this.roleId = builder.roleId;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String lastName;
        private String identityDocument;
        private String phone;
        private String email;
        private String password;
        private LocalDate birthDate;
        private Long roleId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder identityDocument(String identityDocument) {
            this.identityDocument = identityDocument;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder roleId(Long roleId) {
            this.roleId = roleId;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleid) {
        this.roleId = roleid;
    }
}
