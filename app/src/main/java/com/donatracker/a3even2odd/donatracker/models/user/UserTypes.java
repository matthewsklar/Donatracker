package com.donatracker.a3even2odd.donatracker.models.user;

/**
 * Enum class of all UserTypes
 *
 * @author Kris Lee
 */
public enum UserTypes {
    ADMIN               ("Admin"),
    USER                ("User"),
    LOCATION_EMPLOYEE   ("Location Employee");

    private final String userType;

    UserTypes(String userType) {
        this.userType = userType;
    }

    /**
     * Getter for UserType.
     * @return String version of UserType
     */
    public String getUserType() {
        return userType;
    }
}
