package com.spartanHardware.model.entity;

public enum Role {
    ADMIN,USER;

    private static final String PREFIX = "ROLE_";

    public String getFullRoleName() {
        return PREFIX + this.name();
    }

    public String getSimpleRoleName() {
        return this.name();
    }
}
