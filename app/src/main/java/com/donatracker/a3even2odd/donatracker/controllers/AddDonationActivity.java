package com.donatracker.a3even2odd.donatracker.controllers;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.donation.Donation;
import com.donatracker.a3even2odd.donatracker.models.location.Locations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddDonationActivity extends Activity {
    private Spinner locationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        setupLocationSpinner();
    }

    /**
     * Setup the data available in the location spinner.
     */
    private void setupLocationSpinner() {
        locationSpinner = findViewById(R.id.locationSpinner);
        locationSpinner.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Locations.getLocList()));
    }

    /**
     * Get the current time based on the date and return it as a string.
     *
     * @return the current time as a string
     */
    private String getDate() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);

        String formattedDate = dateFormat.format(date);

        return formattedDate;
    }

    /**
     * Handler for add button.
     *
     * @param v the button
     */
    public void onAddPressed(View v) {
        new Donation(getDate(), (Locations) locationSpinner.getSelectedItem(),
                findViewById(R.id.inputDescriptionShort).toString(),
                findViewById(R.id.inputDescriptionFull).toString(),
                findViewById(R.id.inputValue).toString());

        finish();
    }
}
