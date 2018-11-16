package com.donatracker.a3even2odd.donatracker.models.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Code implementation of users.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class User implements Serializable/*, Persistable<User> */ {
    /**
     * Location of the persistent save file containing user data.
     */
    public static final String SAVE_FILE = "user_data.bin";

    /**
     * Map of users mapped by accountId(username).
     */
    private static Map<String, User> users = new HashMap<>();

    /**
     * Local copy of users.
     */
    private Map<String, User> usersCopy = new HashMap<>();

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
     * Getter for users HashMap
     *
     * @return Map of all users
     */
    public static Map<String, User> getUsers() { return users; }

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
     * getter for accountType
     *
     * @return accountType
     */
    public UserTypes getAccountType() {
        return accountType;
    }

    /**
     * user constructor
     *
     * @param username the user's username
     * @param password the user's password
     * @param accountType the user's UserType
     */
    public User(String username, String password ,UserTypes accountType){
        this.accountId = username;
        this.password = password;
        this.accountType = accountType;

        users.put(accountId, this);

        usersCopy.clear();
        usersCopy.putAll(users);
    }

//    /**
//     * User constructor with default userType
//     *
//     * @param username the User's username
//     * @param password the User's password
//     */
//    public User(String username, String password) {
//        this(username, password, UserTypes.USER);
//    }

    /**
     * Load the saved user into the current donation.
     *
     * Add the saved user data of user to the current projects list of users.
     *
     * @param savedUser the users saved in persistent data
     */
    public static void load(Map<String, User> savedUser) {
        if (savedUser == null) {
            return;
        }

        users.putAll(savedUser);
    }

    /**
     * Get the persistent data of the user.
     *
     * @return persistent data of the user
     */
    public Map<String, User> getPersistentData() {
        return usersCopy;
    }

}
