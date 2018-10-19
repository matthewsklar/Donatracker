package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.login.Login;
import com.donatracker.a3even2odd.donatracker.models.login.LoginSingleton;

public class LoginActivity extends AppCompatActivity {
    /**
     * Global instance of LoginSingleton containing data about login.
     */
    private LoginSingleton loginSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginSingleton = LoginSingleton.getInstance();
    }

    /**
     * Button handler for login button.
     *
     * @param v the button
     */
    public void onLoginPressed(View v) {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        Login login = new Login(username, password);

        if (login.verifyLogin()) {
            Log.d("Login", "Successfully logged in");
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);

            finish();
        } else {
            Log.d("Login", "User failed to login for the " +
                    loginSingleton.getLoginAttempts() + " time.");

            login.handleResetAttemptCounter();

            TextView error = findViewById(R.id.error);

            if (login.lockout()) {
                error.setText(getString(R.string.lockout,
                        Math.round((loginSingleton.getLoginAttempts() - 3) *
                                loginSingleton.getLockoutData().getAttemptReset())));
            } else {
                error.setText(R.string.error_incorrect_login);
            }

            error.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Button handler for cancel button.
     *
     * @param v the button
     */
    public void onCancelPressed(View v) {
        finish();
    }
}
