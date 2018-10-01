package com.donatracker.a3even2odd.donatracker.models.login;

public class LockoutData {
    // TODO: Remove default values
    private int attempts = 3;
    private float attemptReset = 2.0f;
    private int lockout = 3;

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

    /**
     * Getter for lockout.
     *
     * @return lockout
     */
    public int getLockout() {
        return lockout;
    }

    /**
     * Setter for lockout.
     *
     * @param lockout the amount of minutes a user is locked out for
     */
    public void setLockout(int lockout) {
        this.lockout = lockout;
    }
}
