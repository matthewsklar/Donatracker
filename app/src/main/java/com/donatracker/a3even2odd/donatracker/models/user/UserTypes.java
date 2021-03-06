package com.donatracker.a3even2odd.donatracker.models.user;

public enum UserTypes {
    ADMIN               ("Admin"),
    USER                ("User"),
    LOCATION_EMPLOYEE   ("Location Employee");

    private final String userType;

    UserTypes(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}
