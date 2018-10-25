package com.donatracker.a3even2odd.donatracker.models.donation;

import com.donatracker.a3even2odd.donatracker.models.location.Locations;

import java.util.LinkedList;

/**
 * Code implementation of donations.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class Donation {
    /**
     * Global list of all the donations.
     */
    private static LinkedList<Donation> donations;

    /**
     * The timestamp of when the donation was made.
     */
    private String timeStamp;

    /**
     * The location the donation was made in.
     */
    private Locations location;

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
    private String value;

    /**
     * The category of the donation.
     */
    private String category;

    /**
     * The comment for the donation.
     */
    private String comment;

    // TODO: Support optional types

    /* Getters and Setters */
    /**
     * Getter for donations.
     */
    public static LinkedList<Donation> getDonations() {
        return donations;
    }

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
    public Locations getLocation() {
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
    public String getValue() {
        return value;
    }

    /**
     * Getter for category.
     *
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Getter for comment.
     *
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Constructor for Donation.
     *
     * @param timeStamp when the donation was made.
     * @param location where the donation was made
     * @param descriptionShort short description of the donation
     * @param descriptionFull full description of the donation
     * @param value amount donated (in dollars)
     * @param category category of the donation
     */
    public Donation(String timeStamp, Locations location, String descriptionShort,
                    String descriptionFull, String value, String category, String comment) {
         donations = new LinkedList<>();

        this.timeStamp = timeStamp;
        this.location = location;
        this.descriptionShort = descriptionShort;
        this.descriptionFull = descriptionFull;
        this.value = value;
        this.category = category;
        this.comment = comment;

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

    /**
     * Convert this Donation into a string showing all the data contained in it.
     *
     * @return the string for this Donation
     */
    @Override
    public String toString() {
        return String.format("{ Time Stamp: %s, Location: %s, Short Description: %s, " +
                "Full Description: %s, Category: %s }", timeStamp, location, descriptionShort,
                descriptionFull, category);
    }
}
