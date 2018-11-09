package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.donation.Donation;
import com.donatracker.a3even2odd.donatracker.models.location.Locations;

import java.util.List;

public class LocationListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        View recyclerView = findViewById(R.id.list_of_locations);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

    }

    /**
     * sets RecyclerView adapter and Layout
     *
     * @param recyclerView the recyclerView
     */
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        Log.d("location_data", "setupRecyclerView ran");
        recyclerView.setAdapter(new RecyclerViewAdapter(Locations.getLocList(), Donation.getDonations()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }


    /**
     * RecyclerViewAdapter inner class
     */
    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        /**
         * List of data to be put into recyclerView
         */
        private final List<Locations> locList;

        /**
         * recyclerViewAdapter constructor
         *
         * @param locations list of elements(locations) for recyclerView
         */
        RecyclerViewAdapter(List<Locations> locations, List<Donation> donations) {
            Log.d("location_data", "Adapter constructor " + locations.get(1).toString());
            locList = locations;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //gets view for viewholder
            Log.d("location_data", "CreateViewHolder ran");
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.location_list_content, parent, false);
            Log.d("location_data", "view" + view.toString());
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
            Log.d("location_data", "onBindViewHolder ran " + position);
            //sets view for viewholder
            holder.location = locList.get(position);

            holder.idView.setText("" + (position + 1));
            holder.contentView.setText((locList.get(position)).getName());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, LocationDetailActivity.class);
                    intent.putExtra(LocationDetailFragment.ARG_LOCATION_ID, holder.location.getLocationId());
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            Log.d("location_data", "getItemCount" + locList.size());
            return locList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View view;
            final TextView idView;
            final TextView contentView;
            Locations location;

            ViewHolder(View view) {
                super(view);
                this.view = view;
                idView = view.findViewById(R.id.id);
                contentView = view.findViewById(R.id.content);
                Log.d("location_data", "ViewHolder constructor ran /n" + idView.getText());
            }

            @Override
            public String toString() {
                return super.toString() + " '" + contentView.getText() + "'";
            }
        }
    }
}
