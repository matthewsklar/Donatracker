package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.donation.Donation;

import java.util.List;

public class ViewDonationsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_donations);

        View recyclerView = findViewById(R.id.listDonations);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        Log.d("donation", "setupRecyclerView ran");
        recyclerView.setAdapter(new ViewDonationsActivity.RecyclerViewAdapter(Donation.getDonations()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
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
