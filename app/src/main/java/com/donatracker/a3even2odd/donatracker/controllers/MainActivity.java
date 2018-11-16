package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.parser.CsvParser;
import com.donatracker.a3even2odd.donatracker.models.user.UserTypes;
import com.donatracker.a3even2odd.donatracker.models.location.Locations;

import java.io.InputStream;
import java.util.List;

/**
 * Main Acitivty for the main screen of the app.
 *
 * @author Matt Sklar
 */
public class MainActivity extends AppCompatActivity {

    public static boolean var = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadElements();
        loadLocation();
    }

    /**
     * Load elements based on what type of user is logged in.
     */
    private void loadElements() {
        UserTypes userType = (UserTypes) getIntent().getSerializableExtra("EXTRA_USER_TYPE");

        switch (userType) {
            case ADMIN:
                break;
            case USER:
                break;
            case LOCATION_EMPLOYEE:
                findViewById(R.id.buttonAddDonation).setVisibility(View.VISIBLE);
                findViewById(R.id.buttonViewDonations).setVisibility(View.VISIBLE);

                break;
            default:
                break;
        }
    }

    /**
     * Load the locations from the data.
     */
    private void loadLocation() {
        if (var) {
            InputStream inputStream = getResources().openRawResource(R.raw.location_data);
            CsvParser csvParser = new CsvParser(inputStream);
            List locList = csvParser.Parse();

            String[] arr = (String[]) locList.get(0);

            Log.d("location_data", arr[0]);
            for (int i = 1; i < locList.size(); i++) {
                if (locList.get(i) != null) {
                    new Locations(((String[]) locList.get(i))[1], (String[]) locList.get(i));
                }
            }
            var = false;
        }
    }

    /**
     * Handler for add donations button.
     *
     * @param v the button
     */
    public void onAddPressed(View v) {
        Intent addDonationIntent = new Intent(this, AddDonationActivity.class);

        startActivity(addDonationIntent);
    }

    /**
     * Handler for add view donations button.
     *
     * @param v the button
     */
    public void onViewDonationsPressed(View v) {
        Intent viewDonationsIntent = new Intent(this, ViewDonationsActivity.class);
        startActivity(viewDonationsIntent);
    }

    /**
     * Handler for Locations Button.
     *
     * @param v the button
     */
    public void onLocationsPressed(View v) {
        Intent locationListIntent = new Intent(this, LocationListActivity.class);

        startActivity(locationListIntent);
    }

    /**
     * Handler for Map Button
     *
     * @param v the button
     */
    public void onMapPressed(View v) {
        Intent mapIntent = new Intent(this,MapsActivity.class);

        startActivity(mapIntent);
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
}
