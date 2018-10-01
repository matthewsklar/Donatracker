package com.donatracker.a3even2odd.donatracker.models.user;

import java.util.HashMap;


public class User {
    /**
     * the Id of the user. currently saved as the username
     */
    private String accountId;
    /**
     * the password of the user
     */
    private String password;
    /**
     * user type
     */
    private UserTypes accountType;
    /**
     * Map of users mapped by accountId(username).
     */
    private static HashMap<String, User> users = new HashMap<>();

    /**
     * Getter for users HashMap
     *
     * @return Map of all users
     */
    public static HashMap<String, User> getUsers() { return users; }

    /**
     * getter for accountId
     *
     * @return accountId
     */
    public String getAccountId() {
       return accountId;
    }

    /**
     * getter for password
     *
     * @return user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * user constructor
     *
     * @param username the user's username
     * @param password the user's password
     */
    public User(String username, String password ,UserTypes accountType){
        this.accountId = username;
        this.password = password;
        this.accountType = accountType;
        users.put(accountId, this);
    }

    /**
     * User constructor with default userType
     *
     * @param username the User's username
     * @param password the User's password
     */
    public User(String username, String password) {
        this(username, password, UserTypes.USER);
    }

}
