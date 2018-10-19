package com.donatracker.a3even2odd.donatracker.models.location;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Locations {
    private Locations location;
    private String name;
    private String[] data;
    private static List<Locations> locList = new ArrayList<>();

    public static List<Locations> getLocList() {
        return locList;
    }

    public String getName() {
        return name;
    }

    public String[] getData() {
        return data;
    }

    public Locations getLocation() {
        return this;
    }

    public Locations(String name, String[] locData) {
        this.name = name;
        data = locData;
        location = this;
        locList.add(this);
    }

    public String toString() {
        return getLocationId() + name;
    }

    public int getLocationId() {
        return parseInt(data[0]);
    }

    public static Locations findLocationById(int locationId) {
        for (Locations l : getLocList()) {
            if (l.getLocationId() == locationId) {
                return l;
            }
        }
        Log.d("Details", "Didnt find id " + locationId);
        return null;
    }

    public String getAddress() {
        return getData()[4] + "\n" + getData()[5] + ", " + getData()[6];
    }
}
