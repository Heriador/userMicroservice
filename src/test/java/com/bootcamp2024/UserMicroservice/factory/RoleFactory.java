package com.bootcamp2024.UserMicroservice.factory;

import com.bootcamp2024.UserMicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.bootcamp2024.UserMicroservice.domain.model.Role;

public class RoleFactory {

    private static final Role role;
    private static final Role warehouseAss;
    private static final Role client;

    static {
        role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
        role.setDescription("Administrator");

        warehouseAss = new Role(2L, "WAREHOUSE_ASSISTANT", "Warehouse Assistant");
        client = new Role(3L, "CLIENT", "Client");
    }

    public static Role getRole() {
        return role;
    }

    public static Role getWarehouseAss() {
        return warehouseAss;
    }

    public static Role getClient() {
        return client;
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
        roleEntity.setId(warehouseAss.getId());
        roleEntity.setName(warehouseAss.getName());
        roleEntity.setDescription(warehouseAss.getDescription());
        return roleEntity;
    }

    public static RoleEntity getClientEntity() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(client.getId());
        roleEntity.setName(client.getName());
        roleEntity.setDescription(client.getDescription());
        return roleEntity;
    }

}
