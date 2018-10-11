package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;

import java.util.List;

import static com.donatracker.a3even2odd.donatracker.controllers.MainActivity.getLocList;

public class LocationListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list_content);

        RecyclerView recyclerView = findViewById(R.id.locationList);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        recyclerView.setAdapter(new RecyclerViewAdapter(getLocList()));
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private final List<String[]> locList;

        public RecyclerViewAdapter(List<String[]> locations) {
            locList = locations;
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_location_list, parent, false);
            return new ViewHolder(view);
        }

        public void onBindViewHolder(final ViewHolder holder, int position) {


            holder.locList = locList;

            holder.idView.setText("" + locList.get(position)[0]);
            holder.contentView.setText(locList.get(position)[1]);
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, LocationDetailActivity.class);

                    context.startActivity(intent);
                }
            });

        }
        public int getItemCount() {
            return locList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View view;
            public final TextView idView;
            public final TextView contentView;
            public List locList;


            public ViewHolder(View view) {
                super(view);
                this.view = view;
                this.idView = (TextView) view.findViewById(R.id.id);
                this.contentView = (TextView) view.findViewById(R.id.content);
            }

            public String toString() {
                return super.toString() + " '" + contentView.getText() + "'";
            }
        }
    }



}
