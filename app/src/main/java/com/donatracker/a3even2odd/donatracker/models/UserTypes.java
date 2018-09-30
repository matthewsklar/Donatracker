package com.donatracker.a3even2odd.donatracker.models;

public enum UserTypes {

    ADMIN       ("admin"),
    LOCATION    ("location"),
    USER        ("user"),
    EMPLOYEE    ("employee");

    private final String userType;


    UserTypes(String userType) {
        this.userType = userType;
    }

    public String getUserTpye() {
        return userType;
    }

}
