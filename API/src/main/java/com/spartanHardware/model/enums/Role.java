package com.spartanHardware.model.enums;

public enum Role {
    ADMIN,USER,CUSTOMER,WAREHOUSE_MANAGER;

    private static final String PREFIX = "ROLE_";

    public String getFullRoleName() {
        return PREFIX + this.name();
    }

    public String getSimpleRoleName() {
        return this.name();
    }
}
