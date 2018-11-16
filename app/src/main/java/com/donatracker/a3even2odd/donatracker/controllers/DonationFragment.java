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

/**
 * Fragment used to view donations.
 *
 * @author Nathan Eason
 */
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
            Bundle arguments = getArguments();
            if (arguments.containsKey(ARG_DONATION)) {
                String donationId = arguments.getString(ARG_DONATION);
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
            showDonation(R.id.textTimeStamp, donation.getTimeStamp(), view);
            showDonation(R.id.textLocation, donation.getLocation(), view);
            showDonation(R.id.textName, donation.getName(), view);
            showDonation(R.id.textDescriptionShort, donation.getDescriptionShort(), view);
            showDonation(R.id.textFullDescription, donation.getDescriptionFull(), view);
            showDonation(R.id.textValue, donation.getValue(), view);
            showDonation(R.id.textComment, donation.getComment(), view);
            showDonation(R.id.textDonationViewLocation, donation.getCategory(), view);
        }
        return view;
    }

    private void showDonation(int id, Object text, View view) {
        ((TextView) view.findViewById(id)).setText(text.toString());
    }
}
