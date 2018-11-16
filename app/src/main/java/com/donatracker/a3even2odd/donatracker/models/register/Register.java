package com.donatracker.a3even2odd.donatracker.models.register;

import com.donatracker.a3even2odd.donatracker.models.user.User;

import java.util.Map;

/**
 * Background class used when registering a user.
 *
 * @author Matt Sklar
 */
public class Register {
    /**
     * The registrant's username
     */
    private final String username;
    /**
     * the registrant's password
     */
    private final String password;
    /**
     * the registrant's password verification
     */
    private final String passwordCheck;

    /**
     * getter method for Users information
     * @return user Map
     */
    private Map<String, User> getUsers() {
        return User.getUsers();
    }

    /**
     * Constructor for Register
     *
     * @param username the username
     * @param password the password
     * @param passwordCheck password verification
     */
    public Register(String username, String password, String passwordCheck) {
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
    }

    /**
     * Verify username is unique
     *
     * @return true if username is unique
     */
    public boolean assertUsername() {
        return !getUsers().containsKey(username);
    }

    /**
     * verify if password is correct
     *
     * @return if passwords match
     */
    public boolean assertPassword() {
        return password.equals(passwordCheck);
    }
}
