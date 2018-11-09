package com.donatracker.a3even2odd.donatracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.donatracker.a3even2odd.donatracker.R;;


public class DonationDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_donation);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Log.d("Detail2", "its null");
            Bundle arguments = new Bundle();
            arguments.putString(DonationFragment.ARG_DONATION,
                    getIntent().getStringExtra(DonationFragment.ARG_DONATION));
            DonationFragment fragment = new DonationFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.layout_donation, fragment)
                    .commit();

        }
    }
}
