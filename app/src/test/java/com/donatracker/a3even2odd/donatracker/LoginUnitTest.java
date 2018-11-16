package com.donatracker.a3even2odd.donatracker;

import com.donatracker.a3even2odd.donatracker.models.login.Login;
import com.donatracker.a3even2odd.donatracker.models.login.LoginSingleton;
import com.donatracker.a3even2odd.donatracker.models.user.User;

import org.junit.Test;

import static com.donatracker.a3even2odd.donatracker.models.user.UserTypes.USER;
import static org.junit.Assert.*;

public class LoginUnitTest {

    @Test
    public void testVerifyLogin() {
        User user1 = new User("Dude1", "bro1", USER); // Username and password.
        User user2 = new User("", "bro2", USER); // No username.
        User user3 = new User("Dude3", "", USER); // No password.
        User user4 = new User("", "", USER); // No username and no password.

        Login log1 = new Login(user1.getAccountId(), user1.getPassword());
        assertTrue(log1.verifyLogin());

        Login log2 = new Login(user2.getAccountId(), user2.getPassword());
        assertFalse(log2.verifyLogin());

        Login log3 = new Login(user3.getAccountId(), user3.getPassword());
        assertFalse(log3.verifyLogin());

        Login log4 = new Login(user4.getAccountId(), user4.getPassword());
        assertFalse(log4.verifyLogin());

        LoginSingleton.getInstance().getLockoutData().setAttempts(2);

        LoginSingleton.getInstance().setLoginAttempts(3);
        assertFalse(log1.verifyLogin());

        LoginSingleton.getInstance().setLoginAttempts(1);
        assertTrue(log1.verifyLogin());

        LoginSingleton.getInstance().setLoginAttempts(2);
        assertTrue(log1.verifyLogin());
    }
}