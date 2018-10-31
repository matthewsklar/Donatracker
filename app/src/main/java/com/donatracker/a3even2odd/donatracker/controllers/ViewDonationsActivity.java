package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.category.Category;
import com.donatracker.a3even2odd.donatracker.models.donation.Donation;
import com.donatracker.a3even2odd.donatracker.models.location.Locations;
import com.donatracker.a3even2odd.donatracker.models.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ViewDonationsActivity extends Activity {
    /**
     * Spinner containing all possible locations for the donation to query donations.
     */
    private Spinner locationSpinner;

    /**
     * Spinner containing all possible categories for the donation to query donations.
     */
    private Spinner categorySpinner;

    /**
     * The donations being shown.
     */
    private View recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_donations);

        setupSpinners();

        recyclerView = findViewById(R.id.listDonations);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView, Donation.getDonations());
    }

    /**
     * Setup a RecyclerView.
     *
     * @param recyclerView an instance of the RecyclerView
     * @param donations the donations to show
     */
    private void setupRecyclerView(@NonNull RecyclerView recyclerView, List<Donation> donations) {
        Log.d("donation", "setupRecyclerView ran");

        recyclerView.setAdapter(new ViewDonationsActivity.RecyclerViewAdapter(donations));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    /**
     * Load values into spinners.
     */
    private void setupSpinners() {
        setupLocationSpinner();
        setupCategorySpinner();
    }

    /**
     * Setup the data available in the location query spinner.
     */
    private void setupLocationSpinner() {
        locationSpinner = findViewById(R.id.locationQuerySpinner);

        locationSpinner.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Locations.getLocList()));
    }

    /**
     * Setup the data available in the category query spinner.
     */
    private void setupCategorySpinner() {
        categorySpinner = findViewById(R.id.categoryQuerySpinner);

        categorySpinner.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Category.getCategories()));
    }

    /**
     * Handler for "Query" button.
     *
     * @param v the button
     */
    public void onQuery(View v) {
        TextInputEditText queryDonationName = findViewById(R.id.queryDonationName);

        List<String> queries = new ArrayList<>();
        queries.add(locationSpinner.getSelectedItem().toString());
        queries.add(categorySpinner.getSelectedItem().toString());
        queries.add(queryDonationName.getText().toString());

        Query<Donation> query = new Query<>();
        List<Donation> queriedDonations = query.query(queries, Donation.getDonations());

        setupRecyclerView((RecyclerView) recyclerView, queriedDonations);
    }

    /**
     * Handler for "Reset" button.
     *
     * @param v the button
     */
    public void onReset(View v) {
        setupRecyclerView((RecyclerView) recyclerView, Donation.getDonations());
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewDonationsActivity.RecyclerViewAdapter.ViewHolder> {

        /**
         * List of data to be put into recyclerView
         */
        private final List<Donation> donations;

        /**
         * recyclerViewAdapter constructor
         *
         * @param donations list of elements(Donation) for recyclerView
         */
        RecyclerViewAdapter(List<Donation> donations) {
            Log.d("donation", "Adapter constructor ");
            this.donations = donations;
        }

        @NonNull
        @Override
        public ViewDonationsActivity.RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //gets view for viewholder
            Log.d("donation", "CreateViewHolder ran");
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_donation_content, parent, false);
            Log.d("donation", "view" + view.toString());
            return new ViewDonationsActivity.RecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewDonationsActivity.RecyclerViewAdapter.ViewHolder holder, int position) {
            Log.d("donation", "onBindViewHolder ran " + position);
            //sets view for viewholder
            holder.donation = donations.get(position);

            holder.idView.setText("" + (position + 1));
            holder.contentView.setText((donations.get(position)).getDescriptionShort());
            holder.view.setOnClickListener(new View.OnClickListener() {
                 @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DonationDetailActivity.class);
                    intent.putExtra(DonationFragment.ARG_DONATION, holder.donation.getDonationId());

                    context.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            Log.d("donation", "getItemCount" + donations.size());
            return donations.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View view;
            final TextView idView;
            final TextView contentView;
            Donation donation;

            ViewHolder(View view) {
                super(view);
                this.view = view;
                idView = view.findViewById(R.id.donationId);
                contentView = view.findViewById(R.id.donation);
                Log.d("donation", "ViewHolder constructor ran /n" + idView.getText());
            }

            @Override
            public String toString() {
                return super.toString() + " '" + contentView.getText() + "'";
            }
        }
    }
}
