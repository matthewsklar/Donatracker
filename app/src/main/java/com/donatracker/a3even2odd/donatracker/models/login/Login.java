package com.donatracker.a3even2odd.donatracker.models.login;

import android.util.Log;

import com.donatracker.a3even2odd.donatracker.models.user.User;
import com.donatracker.a3even2odd.donatracker.models.user.UserTypes;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Handle login protocols.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class Login {
    /**
     * Global instance of LoginSingleton containing data about login.
     */
    private LoginSingleton loginSingleton;

    /**
     * The user's username
     */
    private String username;

    /**
     * The user's password
     */
    private String password;

    /**
     * Type of the user
     */
    private UserTypes userType;

    /**
     * Timer to call methods at designated times.
     */
    private Timer timer;

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

    /**
     * Getter for userType.
     *
     * @return userType
     */
    public UserTypes getUserType() {
        return userType;
    }

    /**
     * Constructor for login.
     *
     * @param username the username
     * @param password the password
     */
    public Login(String username, String password) {
        loginSingleton = LoginSingleton.getInstance();

        this.username = username;
        this.password = password;

        timer = new Timer();
    }

    /**
     * Get user list
     *
     * @return list of all users
     */
    public HashMap<String, User> getUsers() { return User.getUsers(); }

    /**
     * Reset the reset attempts counter
     */
    public void handleResetAttemptCounter() {
        timer.cancel();
        timer = new Timer();

        // TODO: Replace this with destroying no longer used timers
        timer.schedule(resetAttempt(loginSingleton.getLoginAttempts()),
                (int) (loginSingleton.getLockoutData().getAttemptReset() * 60 * 1000));
    }

    /**
     * Determine if the user is currently locked out.
     *
     * A user is locked out if the amount of login attempts is greater than the max allowed.
     *
     * @return if the user is locked out.
     */
    public boolean lockout() {
        return loginSingleton.getLoginAttempts() > loginSingleton.getLockoutData().getAttempts();
    }

    /**
     * Verify that the login information is correct.
     *
     * @return if the login information matches a preexisting account
     */
    public boolean verifyLogin() {
        boolean successfulLogin = !lockout() && verifyUsername() && verifyPassword();

        if (successfulLogin) {
            loginSingleton.setLoginAttempts(0);
            userType = getUsers().get(username).getAccountType();

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

        return getUsers().containsKey(username);
    }

    /**
     * Verify that the password is legal and correct.
     *
     * @return if the password is valid
     */
    private boolean verifyPassword() {
        return password.equals(getUsers().get(username).getPassword());
    }

    /**
     * Create a TimerTask that resets the current login attempt counter.
     *
     * @return an instance of the TimerTask
     */
    private TimerTask resetAttempt(final int attempt) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    if (attempt == loginSingleton.getLoginAttempts()) {
                        loginSingleton.setLoginAttempts(0);

                        Log.d("Login", "Reset login attempts");
                    }
                } catch (Exception e) {
                    Log.e("Login", "Failed to reset attempt\n\t" + e.getMessage());
                }
            }
        };
    }
}
