package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.Login;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    /**
     * The login handler
     */
    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * Button handler for login button.
     *
     * @param v the button
     */
    public void onLoginPressed(View v) {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        login = new Login(username, password);

        if (login.verifyLogin()) {
            Log.d("Login", "Successfully logged in");

            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);

            finish();
        } else {
            TextView error = findViewById(R.id.error);

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
