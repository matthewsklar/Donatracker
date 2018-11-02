package com.donatracker.a3even2odd.donatracker.models.category;

import android.support.annotation.NonNull;

import com.donatracker.a3even2odd.donatracker.models.donation.Donation;
import com.donatracker.a3even2odd.donatracker.models.persistance.Persistable;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Code implementation of donation categories.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class Category implements Serializable, Persistable<Category>, Comparable<Category> {
    /**
     * Global list of all categories.
     */
    private static LinkedList<Category> categories = new LinkedList<>();

    /**
     * The the recent category added.
     */
    private static Category recentCategory;

    /**
     * Location of the persistent save file containing donation data.
     */
    public static final String SAVE_FILE = "category_data.bin";

    /**
     * Local copy of categories.
     */
    private LinkedList<Category> categoryCopy = new LinkedList<>();

    /**
     * The name of the category.
     */
    private String name;

    /* Getters and Setters */
    /**
     * Getter for name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for categories.
     *
     * @return categories
     */
    public static LinkedList<Category> getCategories() {
        return categories;
    }

    /**
     * Getter for recentCategory.
     *
     * @return recentCategory
     */
    public static Category getRecentCategory() {
        return recentCategory;
    }

    /**
     * Constructor.
     *
     * @param name name of the category
     */
    public Category(String name) {
        if (categoryExists(name)) return;

        this.name = name;

        categories.add(this);
        recentCategory = this;
    }

    /**
     * Load the saved donation into the current donation.
     *
     * Add the saved donations data of donations to the current projects list of donations.
     *
     * @param savedCategory the donations saved in persistent data
     */
    public static void load(List<Category> savedCategory) {
        if (savedCategory == null) return;

        categories.addAll(savedCategory);
    }

    /**
     * Check if the category already exists.
     *
     * @param name the name of the new category
     * @return if the category already exists
     */
    private boolean categoryExists(String name) {
        for (Category c : categories) {
            if (c.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Category> getPersistentData() {
        return categoryCopy;
    }

    @Override
    public int compareTo(@NonNull Category c) {
        return toString().compareTo(c.toString());
    }

    /**
     * Convert this Category into a string that contains its name.
     *
     * @return a string representation of this Category.
     */
    @Override
    public String toString() {
        return name;
    }
}
