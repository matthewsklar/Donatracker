package com.donatracker.a3even2odd.donatracker.models.category;

import java.util.LinkedList;

/**
 * Code implementation of donation categories.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class Category {
    /**
     * Global list of all categories.
     */
    private static LinkedList<Category> categories;

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
     * Constructor.
     *
     * @param name name of the category
     */
    public Category(String name) {
        categories = new LinkedList<>();

        if (!categoryExists(name)) {
            this.name = name;

            categories.add(this);
        }
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
}
