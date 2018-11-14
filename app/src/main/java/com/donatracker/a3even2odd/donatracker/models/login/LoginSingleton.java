package com.donatracker.a3even2odd.donatracker.models.login;

import java.util.List;

/**
 * Store global data related to logging in.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class LoginSingleton {
    private static final LoginSingleton ourInstance = new LoginSingleton();

    public static LoginSingleton getInstance() {
        return ourInstance;
    }

    /**
     * Amount of login attempts done in the current time frame.
     */
    private int loginAttempts;

    /**
     * Data relating to lockout protocol
     */
    private LockoutData lockoutData;

    /* Getters and Setters */
    /**
     * Getter for loginAttempts.
     *
     * @return loginAttempts
     */
    public int getLoginAttempts() {
        return loginAttempts;
    }

    /**
     * Setter for loginAttempts.
     *
     * @param loginAttempts set loginAttempts
     */
    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    /**
     * Getter for lockoutData
     *
     * @return lockoutData
     */
    public LockoutData getLockoutData() {
        return lockoutData;
    }

    /**
     * Setter for lockoutData.
     *
     * Set the data in lockout data to the correct value in the List lockoutData.
     *
     * @param lockoutData data that should be added to lockoutData
     */
    public void setLockoutData(List<Float> lockoutData) {
        this.lockoutData.setAttempts(Math.round(lockoutData.get(0)));
        this.lockoutData.setAttemptReset(lockoutData.get(1));
        this.lockoutData.setLockout(Math.round(lockoutData.get(2)));
    }

    /**
     * Constructor for LoginSingleton
     */
    public LoginSingleton() {
        lockoutData = new LockoutData();
    }
}
