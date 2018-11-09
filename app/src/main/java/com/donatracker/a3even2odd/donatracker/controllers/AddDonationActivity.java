package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.category.Category;
import com.donatracker.a3even2odd.donatracker.models.donation.Donation;
import com.donatracker.a3even2odd.donatracker.models.location.Locations;
import com.donatracker.a3even2odd.donatracker.models.persistance.Persistence;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for activity_add_donation view.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class AddDonationActivity extends Activity {
    /**
     * Spinner containing all possible locations for the donation.
     */
    private Spinner locationSpinner;

    /**
     * Spinner containing all possible categories for the donation.
     */
    private Spinner categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        setupSpinners();
    }

    @Override
    protected void onResume() {
        super.onResume();

        setupCategorySpinner();
        Collections.sort(Category.getCategories());
        categorySpinner.setSelection(Category.indexOfRecentCategory());
    }

    /**
     * Setup all the spinners in the view.
     */
    private void setupSpinners() {
        setupLocationSpinner();
        setupCategorySpinner();
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
     * Setup the data available in the category spinner.
     */
    private void setupCategorySpinner() {
        categorySpinner = findViewById(R.id.categorySpinner);
        categorySpinner.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Category.getCategories()));
    }

    /**
     * Handler for "Add Donation" button.
     *
     * @param v the button
     */
    public void onAddDonationPressed(View v) {
        // Required fields
        TextInputEditText name = findViewById(R.id.queryDonationName);
        TextInputEditText descriptionShort = findViewById(R.id.inputDescriptionShort);
        TextInputEditText descriptionFull = findViewById(R.id.inputDescriptionFull);
        EditText value = findViewById(R.id.inputValue);

        // Optional fields
        TextInputEditText comment = findViewById(R.id.inputComments);

        // Get text of fields
        Editable nameText = name.getText();
        Editable descriptionShortText = descriptionShort.getText();
        Editable descriptionFullText = descriptionFull.getText();
        Editable valueText = value.getText();
        Editable commentText = comment.getText();

        Map<Editable, View> data = new HashMap<>(3);
        data.put(nameText, findViewById(R.id.textEmptyName));
        data.put(descriptionShortText, findViewById(R.id.textEmptyDescriptionShort));
        data.put(descriptionFullText, findViewById(R.id.textEmptyDescriptionFull));
        data.put(valueText, findViewById(R.id.textEmptyValue));

        Donation donate = new Donation();

        if (donate.validateData(data)) {
            donate.addDonation(nameText, (Locations) locationSpinner.getSelectedItem(),
                    descriptionShortText, descriptionFullText, valueText,
                    (Category) categorySpinner.getSelectedItem(), commentText);

            Log.d("Donation", "Added Donation: " + donate.toString());

            Toast.makeText(this, "Donation Added", Toast.LENGTH_SHORT).show();

            Persistence.getInstance().write(Donation.getSaveFile(), getApplicationContext(),
                    donate);

            finish();
        }
    }

    /**
     * Handler for "Add Category" button.
     *
     * @param v the button
     */
    public void onAddCategoryPressed(View v) {
        Intent categoryIntent = new Intent(this, AddCategoryActivity.class);

        startActivity(categoryIntent);
    }
}
