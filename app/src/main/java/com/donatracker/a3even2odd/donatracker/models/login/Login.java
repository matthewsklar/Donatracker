package com.donatracker.a3even2odd.donatracker.models.login;

import android.util.Log;

public class Login {
    /**
     * The user's username
     */
    private String username;

    /**
     * The user's password
     */
    private String password;

    /**
     * Global instance of LoginSingleton containing data about login.
     */
    private LoginSingleton loginSingleton;

    /* Getters and Setters */
    /**
     * Getter for username.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for password.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    // TODO: Remove
    public String test() {
        //return Integer.toString(LoginSingleton.getInstance().getLockoutData().getAttemptReset());
        //Log.d("HelloBye", Integer.toString(LoginSingleton.getInstance().getLockoutData().getAttempts()));
        //Log.d("HelloBye", Integer.toString(LoginSingleton.getInstance().getLockoutData().getAttempts()));
        return "hi";
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

        loginSingleton = LoginSingleton.getInstance();
    }

    /**
     * Verify that the login information is correct.
     *
     * @return if the login information matches a preexisting account
     */
    public boolean verifyLogin() {
        boolean successfulLogin =
                loginSingleton.getLoginAttempts() <= loginSingleton.getLockoutData().getAttempts()
                        && verifyUsername() && verifyPassword();

        if (successfulLogin) {
            loginSingleton.setLoginAttempts(0);

            return true;
        }

        loginSingleton.setLoginAttempts(loginSingleton.getLoginAttempts() + 1);

        return false;
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
