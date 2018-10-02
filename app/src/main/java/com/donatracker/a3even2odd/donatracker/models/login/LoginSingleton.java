package com.donatracker.a3even2odd.donatracker.models.login;

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
     * @param loginAttempts
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
     * Constructor for LoginSingleton
     */
    private LoginSingleton() {
        lockoutData = new LockoutData();

        //loadYaml("../configs/login_config.yaml");
    }
}
