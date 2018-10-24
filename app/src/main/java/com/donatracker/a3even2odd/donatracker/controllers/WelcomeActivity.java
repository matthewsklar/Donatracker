package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.login.LoginSingleton;
import com.donatracker.a3even2odd.donatracker.models.parser.YamlParser;

import java.io.InputStream;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // TODO: Maybe move this
        loadConfigs();
    }

    /**
     * Load config files.
     */
    private void loadConfigs() {
        InputStream inputStream = getResources().openRawResource(R.raw.login_config);
        YamlParser parseLogin = new YamlParser(inputStream);
        List<Float> configList = parseLogin.Parse();

        LoginSingleton.getInstance().setLockoutData(configList);
    }

    /**
     * Button handler for login button.
     *
     * When the login button is pressed, go to the login page.
     *
     * @param v the button
     */
    public void onLoginPressed(View v) {
        Log.d("Login", "Go to login page");

        Intent loginIntent = new Intent(this, LoginActivity.class);

        startActivity(loginIntent);
    }

    /**
     * Button handler for registration button.
     *
     * When the registration button is pressed, go to the registration page.
     *
     * @param v the button
     */
    public void onRegisterPressed(View v) {
        Log.d("Registration","Go to Registation page");

        Intent registrationIntent = new Intent(this, RegistrationActivity.class);

        startActivity(registrationIntent);
    }
}
