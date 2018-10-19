package com.donatracker.a3even2odd.donatracker.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.location.LocationDetailFragment;



public class LocationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //i changed this
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
                    //change back to magic
                    .replace(R.id.layout_location, fragment)
                    .commit();

        }
    }



}
