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
import com.donatracker.a3even2odd.donatracker.models.donation.Donation;



public class DonationFragment extends Fragment {

    public static final String ARG_DONATION = "arg_donation";

    private Donation donation;

    //private OnFragmentInteractionListener mListener;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //sets locationId and location
        // based on argument passed in from LocationDetailActivity
        try {
            if (getArguments().containsKey(ARG_DONATION)) {
                int donationId = getArguments().getInt(ARG_DONATION);
                donation = Donation.findDonationById(donationId);
            }
        } catch (NullPointerException e) {
            Log.e("Location_Detail", e.toString());
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donation, container, false);
        Log.d("Detail", "View created");

        //sets location data into views
        if (donation != null) {
            ((TextView) view.findViewById(R.id.textTimeStamp)).setText(donation.getTimeStamp());
            ((TextView) view.findViewById(R.id.textLocation)).setText(donation.getLocation().toString());
            ((TextView) view.findViewById(R.id.textDescriptionShort)).setText(donation.getDescriptionShort());
        }
        return view;
    }
}
