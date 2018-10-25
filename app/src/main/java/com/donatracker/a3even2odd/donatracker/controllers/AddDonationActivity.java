package com.donatracker.a3even2odd.donatracker.controllers;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.donation.Donation;
import com.donatracker.a3even2odd.donatracker.models.location.Locations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
     * Test the validity of an individual piece of the data that will be added to donation.
     *
     * Data is considered valid if neither it nor the object containing it are null. If the data is
     * invalid, the error message in the view set to VISIBLE, and if the data is valid, the error
     * message in the view is set to GONE.
     *
     * @param test the data to test
     * @param view the view to show or hide depending on
     * @return if the data is valid
     * @throws NullPointerException throw when the test data is null
     */
    private boolean testValidity(Editable test, View view)
            throws NullPointerException {
        if (test == null) throw new NullPointerException("Editable cannot be null");

        if (test.toString().equals("")) {
            view.setVisibility(View.VISIBLE);

            return false;
        } else {
            view.setVisibility(View.GONE);
        }
        return true;
    }

    /**
     * Check if all the data to be added to the donation is valid.
     *
     * Data is considered valid if neither it nor the object containing it are null.
     *
     * @param map holds each object containing the data and the corresponding view for it to show
     *            an error
     * @return if the data is valid
     */
    private boolean validateData(HashMap<Editable, View> map) {
        boolean valid;

        for (Editable e : map.keySet()) {
            try {
                valid = testValidity(e, map.get(e));

                if (!valid) {
                    return false;
                }
            } catch (NullPointerException ex) {
                Log.e("Donate", "Failed to add donation because an editable was null\n" + ex);
            }
        }

        return true;
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
        TextInputEditText descriptionShort = findViewById(R.id.inputDescriptionShort);
        TextInputEditText descriptionFull = findViewById(R.id.inputDescriptionFull);
        EditText value = findViewById(R.id.inputValue);
        TextInputEditText category = findViewById(R.id.inputCategory);

        HashMap<Editable, View> data = new HashMap<>(4);
        data.put(descriptionShort.getText(), findViewById(R.id.textEmptyDescriptionShort));
        data.put(descriptionFull.getText(), findViewById(R.id.textEmptyDescriptionFull));
        data.put(value.getText(), findViewById(R.id.textEmptyValue));
        data.put(category.getText(), findViewById(R.id.textEmptyCategory));

        boolean valid = validateData(data);

        if (valid) {
            new Donation(getDate(), (Locations) locationSpinner.getSelectedItem(),
                    descriptionShort.toString(), descriptionFull.toString(), value.toString(),
                    category.toString());

            finish();
        }
    }
}
