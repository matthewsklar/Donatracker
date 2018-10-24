package com.donatracker.a3even2odd.donatracker.models.donation;

import java.util.LinkedList;

public class Donation {
    /**
     * Global list of all the donations.
     */
    public static LinkedList<Donation> donations = new LinkedList<>();

    /**
     * The timestamp of when the donation was made.
     */
    private String timeStamp;

    /**
     * The location the donation was made in.
     */
    private String location;

    /**
     * A short description of the item for display purposes.
     */
    private String descriptionShort;

    /**
     * The full description of the item.
     */
    private String descriptionFull;

    /**
     * The amount donated (in dollars).
     */
    private double value;

    // TODO: Support optional types

    /* Getters and Setters */
    /**
     * Getter for timeStamp.
     *
     * @return timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Getter for location.
     *
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter for descriptionShort.
     *
     * @return descriptionShort
     */
    public String getDescriptionShort() {
        return descriptionShort;
    }

    /**
     * Getter for descriptionFull.
     *
     * @return descriptionFull
     */
    public String getDescriptionFull() {
        return descriptionFull;
    }

    /**
     * Getter for value.
     *
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * Constructor for Donation.
     *
     * @param timeStamp when the donation was made.
     * @param location where the donation was made
     * @param descriptionShort short description of the donation
     * @param descriptionFull full description of the donation
     * @param value amount donated (in dollars)
     */
    public Donation(String timeStamp, String location, String descriptionShort,
                    String descriptionFull, double value) {
        this.timeStamp = timeStamp;
        this.location = location;
        this.descriptionShort = descriptionShort;
        this.descriptionFull = descriptionFull;
        this.value = value;

        donations.addLast(this);
    }

    /**
     * Add the donation to the database.
     *
     * @return if the donation was successfully added.
     */
    public boolean addDonation() {
        return true;
    }
}
