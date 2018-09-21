package com.donatracker.a3even2odd.donatracker.models;

public class Login {
    private String username;
    private String password;

    /* Getters and Setters */
    /**
     * Getter for username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Constructor for login.
     *
     * @param username the username
     * @param password the password
     */
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Verify that the login information is correct.
     *
     * @return if the login information matches a preexisting account
     */
    public boolean verifyLogin() {
        return verifyUsername() && verifyPassword();
    }

    /**
     * Verify that the username is legal and correct.
     *
     * @return if the username is valid
     */
    private boolean verifyUsername() {
        // TODO: Check that username matches requirements

        return username.equals("user");
    }

    /**
     * Verify that the password is legal and correct.
     *
     * @return if the password is valid
     */
    private boolean verifyPassword() {
        return password.equals("pass");
    }
}
