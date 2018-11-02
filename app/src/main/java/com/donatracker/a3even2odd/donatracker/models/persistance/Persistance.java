package com.donatracker.a3even2odd.donatracker.models.persistance;

import java.io.File;

/**
 * Abstract class for methods of handling persistance.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public abstract class Persistance {
    /**
     * Save the file.
     *
     * @param file the file to save
     * @return if the file saved successfully
     */
    public abstract boolean save(File file);

    /**
     * Load the file.
     *
     * @param file the file to load
     * @return if the file loaded successfully
     */
    public abstract boolean load(File file);
}
