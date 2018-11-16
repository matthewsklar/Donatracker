package com.donatracker.a3even2odd.donatracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.donatracker.a3even2odd.donatracker.R;

/**
 * Activity to view the details of a location.
 *
 * @author Nathan Eason
 */
public class LocationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_detail);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Log.d("Detail", "its null");
            Bundle arguments = new Bundle();
            arguments.putInt(LocationDetailFragment.ARG_LOCATION_ID,
                    getIntent().getIntExtra(LocationDetailFragment.ARG_LOCATION_ID, 1000));
            LocationDetailFragment fragment = new LocationDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout_location, fragment)
                    .commit();

        }
    }



}
