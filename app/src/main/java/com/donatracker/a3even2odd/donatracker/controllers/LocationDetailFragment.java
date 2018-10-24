package com.donatracker.a3even2odd.donatracker.controllers;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.dummy.DummyContent;
import com.donatracker.a3even2odd.donatracker.dummy.DummyContent.DummyItem;
import com.donatracker.a3even2odd.donatracker.models.location.Locations;


public class LocationDetailFragment extends Fragment {

    // TODO: Customize parameter argument names
    public static final String ARG_LOCATION_ID = "location_id";
    //private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    //private int mColumnCount = 1;
    //private OnListFragmentInteractionListener mListener;
    private Locations location;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LocationDetailFragment() {
    }

    // TODO: Customize parameter initialization

    /*public static LocationDetailFragment newInstance(int columnCount) {
        LocationDetailFragment fragment = new LocationDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }*/
        if (getArguments().containsKey(ARG_LOCATION_ID)) {
            int locationId = getArguments().getInt(ARG_LOCATION_ID);
            Log.d("Details","detail for location "+ locationId);
            location = Locations.findLocationById(locationId);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.location_detail, container, false);
        Log.d("Detail", "View created");

        // Set the adapter
        /*if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new LocationDetailAdapter(DummyContent.ITEMS, mListener));
        }
        */
        if (location != null) {
            Log.d("Detail", "Location non null");
            Log.d("Detail", "locatoin" + location.getAddress());
            ((TextView) view.findViewById(R.id.location_name)).setText(location.getName());
            ((TextView) view.findViewById(R.id.location_type)).setText(location.getData()[8]);
            ((TextView) view.findViewById(R.id.location_long)).setText(location.getData()[3]);
            ((TextView) view.findViewById(R.id.location_lat)).setText(location.getData()[2]);
            ((TextView) view.findViewById(R.id.location_address)).setText(location.getAddress());
            ((TextView) view.findViewById(R.id.location_phone)).setText(location.getData()[9]);
        }
        return view;
    }

    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
  /*  public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
    */
}
