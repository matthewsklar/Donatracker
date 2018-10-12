package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.parser.CsvParser;
import com.donatracker.a3even2odd.donatracker.models.user.Locations;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadLocation();
    }

    private void loadLocation() {
        InputStream inputStream = getResources().openRawResource(R.raw.location_data);
        CsvParser csvParser = new CsvParser(inputStream);
        List locList = csvParser.Parse();

        String[] arr = (String[]) locList.get(0);

        Log.d("location_data", arr[0]);
        for(int i = 1; i < locList.size(); i++) {
            if (locList.get(i) != null) {
                new Locations(((String[]) locList.get(i))[1], (String[])locList.get(i));
            }
        }
    }

    /**
     * Handler for logout button.
     *
     * @param v the button
     */
    public void onLogoutPressed(View v) {
        Intent logoutIntent = new Intent(this, LoginActivity.class);

        startActivity(logoutIntent);

        Log.d("Logout", "Successfully logged out");

        finish();
    }

    /**
     * Handler for Locations Button/
     *
     * @param v the button
     */
    public void onLocationsPressed(View v) {
        Intent locationListIntent = new Intent(this, LocationListActivity.class);

        startActivity(locationListIntent);

    }
}
