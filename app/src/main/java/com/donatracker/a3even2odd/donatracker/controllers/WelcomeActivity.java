package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.donatracker.a3even2odd.donatracker.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    /**
     * Button handler for login button.
     *
     * @param v the button
     */
    public void onLoginPressed(View v) {
        Log.d("Login", "Go to login page");

        Intent loginIntent = new Intent(this, LoginActivity.class);

        startActivity(loginIntent);
    }
}
