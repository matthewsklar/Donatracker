package com.donatracker.a3even2odd.donatracker.controllers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.location.Locations;

/**
 * Fragment to view the details of a donation.
 *
 * @author Nathan Eason
 */
public class LocationDetailFragment extends Fragment {
    /**
     * Location Id passed from LocationListActivity
     */
    public static final String ARG_LOCATION_ID = "location_id";

    /**
     * current location
     */
    private Locations location;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //sets locationId and location
        // based on argument passed in from LocationDetailActivity
        try {
            if (getArguments().containsKey(ARG_LOCATION_ID)) {
                int locationId = getArguments().getInt(ARG_LOCATION_ID);
                Log.d("Details", "detail for location " + locationId);
                location = Locations.findLocationById(locationId);
            }
        } catch (NullPointerException e) {
            Log.e("Location_Detail", e.toString());
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.location_detail, container, false);
        Log.d("Detail", "View created");

        //sets location data into views
        if (location != null) {
            Log.d("Detail", "Location non null");
            Log.d("Detail", "location" + location.getAddress());
            ((TextView) view.findViewById(R.id.location_name))   .setText(location.getName());
            ((TextView) view.findViewById(R.id.location_type))   .setText(location.getData()[8]);
            ((TextView) view.findViewById(R.id.location_long))   .setText(location.getData()[3]);
            ((TextView) view.findViewById(R.id.location_lat))    .setText(location.getData()[2]);
            ((TextView) view.findViewById(R.id.location_address)).setText(location.getAddress());
            ((TextView) view.findViewById(R.id.location_phone))  .setText(location.getData()[9]);
        }
        return view;
    }
}
