package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.Register;
import com.donatracker.a3even2odd.donatracker.models.User;
import com.donatracker.a3even2odd.donatracker.models.UserTypes;

public class RegistrationActivity extends AppCompatActivity {

    private Spinner userTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userTypeSpinner = findViewById(R.id.userTypeSpinner);
        userTypeSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, UserTypes.values()));
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
        TextView passwordCheck = findViewById(R.id.passwordCheck);
        TextView errorUsername = findViewById(R.id.errorUsername);

        if(!register.assertPassword()) {
            passwordCheck.setVisibility(View.VISIBLE);
        } else {
            passwordCheck.setVisibility(View.INVISIBLE);
        }
        if (!register.assertUsername()) {
            errorUsername.setVisibility(View.VISIBLE);
        } else {
            errorUsername.setVisibility(View.INVISIBLE);
        }
        if(register.assertUsername() && register.assertPassword()) {
            new User(username, password, (UserTypes)userTypeSpinner.getSelectedItem());
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        }
    }

    /**
     * Button handler ofr Cancel Button
     *
     * @param v the Button
     */
    public void onCancelPressed(View v) {
        Intent welcomeIntent = new Intent (this, WelcomeActivity.class);
        startActivity(welcomeIntent);
        finish();
    }

}
