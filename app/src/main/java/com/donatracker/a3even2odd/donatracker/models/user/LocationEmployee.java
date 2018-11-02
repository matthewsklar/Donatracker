package com.donatracker.a3even2odd.donatracker.models.user;

import com.donatracker.a3even2odd.donatracker.models.location.Locations;

public class LocationEmployee extends User {

    private Locations location;

    public Locations getEmployeeLocation() {
        return location;
    }

    LocationEmployee(String username, String password) {
        super(username, password, UserTypes.LOCATION_EMPLOYEE);
    }

    LocationEmployee(String username, String password, Locations location) {
        super(username, password, UserTypes.LOCATION_EMPLOYEE);
        this.location = location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }
}
