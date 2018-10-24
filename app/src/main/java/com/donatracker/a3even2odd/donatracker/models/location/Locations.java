package com.donatracker.a3even2odd.donatracker.models.location;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Locations {

    /**
     * the name of the location
     */
    private String name;
    /**
     * an array of the location details
     * data[0]:  key
     * data[1]:  name
     * data[2]:  latitude
     * data[3]:  longitude
     * data[4]:  street address
     * data[5]:  city
     * data[6]:  state
     * data[7]:  zip
     * data[8]:  type
     * data[9]:  phone
     * data[10]: website
     */
    private String[] data;
    /**
     * list of locations
     */
    private static List<Locations> locList = new ArrayList<>();

    /**
     * getter for list of locations
     *
     * @return a list of locations
     */
    public static List<Locations> getLocList() {
        return locList;
    }

    /**
     * getter for name
     *
     * @return location name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for location data
     *
     * @return location data array
     */
    public String[] getData() {
        return data;
    }

    /**
     * getter for location id
     *
     * @return location key (Id)
     */
    public int getLocationId() {
        return parseInt(data[0]);
    }

    /**
     * location constructor
     *
     * @param name the locations name
     * @param locData location data
     */
    public Locations(String name, String[] locData) {
        this.name = name;
        data = locData;
        locList.add(this);
    }

    /**
     * toString for location
     *
     * @return location id and name
     */
    public String toString() {
        return getLocationId() + name;
    }

    /**
     * returns a location based on given id. returns null if no location found
     *
     * @param locationId location id passed in
     * @return location based on id
     */
    public static Locations findLocationById(int locationId) {
        for (Locations l : getLocList()) {
            if (l.getLocationId() == locationId) {
                return l;
            }
        }
        Log.d("Details", "Didnt find id " + locationId);
        return null;
    }

    /**
     * formats address from data
     *
     * @return address
     */
    public String getAddress() {
        return getData()[4] + "\n" + getData()[5] + ", " + getData()[6];
    }
}
