package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.Register;
import com.donatracker.a3even2odd.donatracker.models.User;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    /**
     * Button handler for Register Button
     *
     * @param v the Button
     */
    public void onRegisterPressed(View v) {
        String username = ((EditText) findViewById(R.id.usernameNew)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordNew)).getText().toString();
        String checkPassword = ((EditText) findViewById(R.id.passwordNew2)).getText().toString();
        Register register = new Register(username, password, checkPassword);

        if(!register.assertPassword()) {
            TextView passwordCheck = findViewById(R.id.passwordCheck);
            passwordCheck.setVisibility(View.VISIBLE);
        } else if (!register.assertUsername()) {
            TextView errorUsername = findViewById(R.id.errorUsername);
            errorUsername.setVisibility(View.VISIBLE);
        } else {
            new User(username, password);
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        }
    }

    public void onCanclePressed(View v) {
        Intent welcomeIntent = new Intent (this, WelcomeActivity.class);
        startActivity(welcomeIntent);
        finish();
    }

}
