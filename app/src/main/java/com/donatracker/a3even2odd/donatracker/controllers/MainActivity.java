package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.donatracker.a3even2odd.donatracker.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Handler for logout button.
     *
     * @param v the button
     */
    public void onLogoutPressed(View v) {
        Intent logoutIntent = new Intent(this, LoginActivity.class);
        
        startActivity(logoutIntent);

        finish();
    }
}
