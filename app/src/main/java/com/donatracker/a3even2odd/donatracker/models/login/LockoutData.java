package com.donatracker.a3even2odd.donatracker.models.login;

/**
 * Store data about locking out users during sign in.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class LockoutData {
    private int attempts;
    private float attemptReset;
    private int lockout;

    /* Getters and Setters */
    /**
     * Getter for attempts.
     *
     * @return attempts
     */
    int getAttempts() {
        return attempts;
    }

    /**
     * Setter for attempts.
     *
     * @param attempts the amount of attempts
     */
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    /**
     * Getter for attemptReset.
     *
     * @return attemptReset
     */
    public float getAttemptReset() {
        return attemptReset;
    }

    /**
     * Setter for attemptReset.
     *
     * @param attemptReset the amount of minutes after an attempt the counter resets at
     */
    public void setAttemptReset(float attemptReset) {
        this.attemptReset = attemptReset;
    }

//    /**
//     * Getter for lockout.
//     *
//     * @return lockout
//     */
//    public int getLockout() {
//        return lockout;
//    }

    /**
     * Setter for lockout.
     *
     * @param lockout the amount of minutes a user is locked out for
     */
    public void setLockout(int lockout) {
        this.lockout = lockout;
    }
}
