package com.donatracker.a3even2odd.donatracker.models.donation;

import android.text.Editable;
import android.util.Log;
import android.view.View;

import com.donatracker.a3even2odd.donatracker.models.category.Category;
import com.donatracker.a3even2odd.donatracker.models.location.Locations;
import com.donatracker.a3even2odd.donatracker.models.persistance.Persistable;
import com.donatracker.a3even2odd.donatracker.models.query.Queryable;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Code implementation of donations.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class Donation implements Serializable, Queryable, Persistable<Donation> {
    /**
     * Global list of all the donations.
     */
    private static LinkedList<Donation> donations = new LinkedList<>();

    /**
     * The amount of donations that have been made.
     */
    private static int numDonations;

    /**
     * Location of the persistent save file containing donation data.
     */
    private static String saveFile = "donation_data.bin";

    /**
     * Local copy of donations.
     */
    private List<Donation> donationsCopy = new LinkedList<>();

    /**
     * ID of donation so we can find it and put em in a list
     */
    private int donationId;

    /**
     * Name of the donation.
     */
    private String name;

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
    private Category category;

    /**
     * The comment for the donation.
     */
    private String comment;

    /* Getters and Setters */
    /**
     * Getter for donations.
     *
     * @return donations
     */
    public static List<Donation> getDonations() {
        return donations;
    }

    /**
     * Getter for saveFile.
     *
     * @return saveFile
     */
    public static String getSaveFile() {
        return saveFile;
    }

    /**
     * Getter for DonationId
     *
     * @return donationId
     */
    public int getDonationId() {
        return donationId;
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
     * Getter for name.
     *
     * @return name
     */
    public String getName() {
        return name;
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
    public Category getCategory() {
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
     * Get the current time based on the date and return it as a string.
     *
     * @return the current time as a string
     */
    private String getDate() {
        Date date = new Date();
        String strDateFormat = "MM/dd/YY hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat, Locale.US);

        return dateFormat.format(date);
    }

    /**
     * Load the saved donation into the current donation.
     *
     * Add the saved donations data of donations to the current projects list of donations.
     *
     * @param savedDonation the donations saved in persistent data
     */
    public static void load(Collection<Donation> savedDonation) {
        if (savedDonation == null) return;

        donations.addAll(savedDonation);
    }

    /**
     * finds donation by id
     *
     * @param id DonationId
     * @return Donation
     */
    public static Donation findDonationById(String id) {
        for (Donation d : donations) {
            if (id.equals(d.getTimeStamp())) {
                return d;
            }
        }
        Log.d("Details", "Didn't find id " + id);
        return null;
    }

    /**
     * Test the validity of an individual piece of the data that will be added to donation.
     *
     * Data is considered valid if neither it nor the object containing it are null. If the data is
     * invalid, the error message in the view set to VISIBLE, and if the data is valid, the error
     * message in the view is set to GONE.
     *
     * @param test the data to test
     * @param view the view to show or hide depending on
     * @return if the data is valid
     * @throws NullPointerException throw when the test data is null
     */
    private boolean testValidity(Editable test, View view)
            throws NullPointerException {
        if (test == null) throw new NullPointerException("Editable cannot be null");

        if ("".equals(test.toString())) {
            view.setVisibility(View.VISIBLE);

            return false;
        } else {
            view.setVisibility(View.GONE);
        }
        return true;
    }

    /**
     * Check if all the data to be added to the donation is valid.
     *
     * Data is considered valid if neither it nor the object containing it are null.
     *
     * @param map holds each object containing the data and the corresponding view for it to show
     *            an error
     * @return if the data is valid
     */
    public boolean validateData(Map<Editable, View> map) {
        boolean valid;
        boolean validity = true;

        for (Editable e : map.keySet()) {
            try {
                valid = testValidity(e, map.get(e));

                if (!valid) {
                    validity = false;
                }
            } catch (NullPointerException ex) {
                Log.e("Donate", "Failed to add donation because an editable was null\n" + ex);
            }
        }

        return validity;
    }

    /**
     * Add the donation to the data structure.
     *
     * @param name name of the donation
     * @param location where the donation was made
     * @param descriptionShort short description of the donation
     * @param descriptionFull full description of the donation
     * @param value amount donated (in dollars)
     * @param category category of the donation
     */
    public void addDonation(Editable name, Locations location, Editable descriptionShort,
                            Editable descriptionFull, Editable value, Category category,
                            Editable comment) {
        this.name = name.toString();
        this.timeStamp = getDate();
        this.location = location;
        this.descriptionShort = descriptionShort.toString();
        this.descriptionFull = descriptionFull.toString();
        this.value = value.toString();
        this.category = category;
        this.comment = comment.toString();

        Log.d("donation","Description:  " + descriptionShort.toString());

        donations.addFirst(this);

        donations.getLast().donationsCopy.clear();
        donationsCopy.addAll(donations);

        location.addInventory(this);
    }

    @Override
    public List<Donation> getPersistentData() {
        return donationsCopy;
    }

    @Override
    public List<String> queryData() {
        List<String> queryList = new ArrayList<>();
        queryList.add(location.toString());
        queryList.add(category.toString());
        queryList.add(name);

        return queryList;
    }

    @Override
    public String toString() {
        return String.format("{ Name: %s, Time Stamp: %s, Location: %s, Short Description: %s, " +
                "Full Description: %s, Category: %s, Comment: %s }", name, timeStamp, location,
                descriptionShort, descriptionFull, category, comment);
    }
}
