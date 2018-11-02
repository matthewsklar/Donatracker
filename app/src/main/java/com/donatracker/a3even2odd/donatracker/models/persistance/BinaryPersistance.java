package com.donatracker.a3even2odd.donatracker.models.persistance;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Implementation of binary serialization based on Persistance.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class BinaryPersistance extends Persistance {
    /**
     * Save the file.
     *
     * @param file the file to save
     * @return if the file saved successfully
     */
    @Override
    public boolean save(File file) {
        boolean success = true;

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            Log.e("UserManagerFacade", "Error writing an entry from binary file",e);
        }

        return success;
    }

    /**
     * Load the file.
     *
     * @param file the file to load
     * @return if the file loaded successfully
     */
    @Override
    public boolean load(File file) {
        return false;
    }
}
