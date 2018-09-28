package com.donatracker.a3even2odd.donatracker.models;

import java.util.HashMap;


public class Register {
    /**
     * The registrant's username
     */
    private String username;
    /**
     * the registrant's password
     */
    private String password;
    /**
     * the registrant's password verification
     */
    private String passwordCheck;

    /**
     * getter method for Users information
     * @return user Map
     */
    public HashMap<String, User> getUsers() {
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
