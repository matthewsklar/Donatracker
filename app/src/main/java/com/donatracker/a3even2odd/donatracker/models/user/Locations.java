package com.donatracker.a3even2odd.donatracker.models.user;

import java.util.ArrayList;
import java.util.List;

public class Locations {
    private String name;
    private String[] data;
    private static List<Locations> locList = new ArrayList<>();

    public static List<Locations> getLocList() {
        return locList;
    }

    public String getName() {
        return name;
    }

    public Locations(String name, String[] locData) {
        this.name = name;
        data = locData;
        locList.add(this);
    }

    public String toString() {
        return data.toString();
    }

}
