package com.bootcamp2024.UserMicroservice.factory;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.bootcamp2024.UserMicroservice.domain.model.Role;

public class RoleFactory {

    private static final Role role;
    private static final Role watehouseAss;

    static {
        role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
        role.setDescription("Administrator");

        watehouseAss = new Role(2L, "WAREHOUSE_ASSISTANT", "Warehouse Assistant");
    }

    public static Role getRole() {
        return role;
    }

    public static Role getWarehouseAss() {
        return watehouseAss;
    }

    public static RoleEntity getRoleEntity() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(role.getId());
        roleEntity.setName(role.getName());
        roleEntity.setDescription(role.getDescription());
        return roleEntity;
    }

    public static RoleEntity getWarehouseAssEntity() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(watehouseAss.getId());
        roleEntity.setName(watehouseAss.getName());
        roleEntity.setDescription(watehouseAss.getDescription());
        return roleEntity;
    }

}
