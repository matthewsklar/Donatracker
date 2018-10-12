package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.donatracker.a3even2odd.donatracker.models.user.Locations;

import java.util.ArrayList;
import java.util.List;

public class LocationListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list_content);
        //recyclerView = findViewById(R.id.list_of_locations);
        //recyclerView.findViewById(R.id.list_of_locations);
        //assert recyclerView != null;
        LayoutInflater inflater = (LayoutInflater)this.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_location_list, null);
        RecyclerView recyclerView1 = (RecyclerView)view.findViewById(R.id.list_of_locations);


        setupRecyclerView((RecyclerView) recyclerView1);

    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(Locations.getLocList());
        //Log.d("location_data", "" + Locations.getLocList().size());
        recyclerView.setAdapter(new RecyclerViewAdapter(Locations.getLocList()));
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private List locList;

        public RecyclerViewAdapter(List locations) {

            locList = locations;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.location_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {

            holder.location = (Locations)locList.get(position);

            holder.idView.setText("" + (position + 1));
            holder.contentView.setText(((Locations)locList.get(position)).getName());
            /*holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, LocationDetailActivity.class);
                    intent.putExtra(

                    startActivity(intent);
                }
            });*/

        }
        public int getItemCount() {
            Log.d("location_data", "getItemCount" + locList.size());
            return locList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View view;
            public final TextView idView;
            public final TextView contentView;
            public Locations location;


            public ViewHolder(View view) {
                super(view);
                this.view = view;
                idView = (TextView) view.findViewById(R.id.id);
                contentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + contentView.getText() + "'";
            }
        }
    }



}
