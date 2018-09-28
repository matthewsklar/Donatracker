package com.donatracker.a3even2odd.donatracker.models;

import java.util.HashMap;


public class User {
    private String accountId;
    private String password;
   // private account accountType;
    private static HashMap<String, User> users = new HashMap<>();

   public static HashMap<String, User> getUsers() { return users; }

   public String getAccountId() {
       return accountId;
   }

   public String getPassword() {
       return password;
   }

    public User(String accountId, String password /**,account accountType)*/ ){
        this.accountId = accountId;
        this.password = password;
        //this.accountType = accountType;
        users.put(accountId, this);
    }

}
