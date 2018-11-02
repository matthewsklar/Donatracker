package com.donatracker.a3even2odd.donatracker.models.persistance;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistence {
    /**
     * Singleton instance of Persistence
     */
    private static final Persistence ourInstance = new Persistence();

    /**
     * Get the singleton instance of Persistence.
     *
     * @return the singleton instance of Persistence
     */
    public static Persistence getInstance() {
        return ourInstance;
    }

    /**
     * Tag to show for errors thrown by Persistence object.
     */
    private final String ERROR_TAG = "Persistence";

    /**
     * Load data from persistent file.
     *
     * @param loc location of the persistent file
     * @param appContext getApplicationData() from the activity calling load
     * @return the object from objectInputStream
     */
    public Object load(String loc, Context appContext) {
        try {
            FileInputStream fileInputStream = appContext.openFileInput(loc);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            objectInputStream.close();

            return obj;
        } catch (FileNotFoundException fnfE) {
            Log.e(ERROR_TAG, "Persistent file not found", fnfE);
        } catch (IOException ioE) {
            Log.e(ERROR_TAG, "Persistent object input stream not found", ioE);
        } catch (ClassNotFoundException csfE) {
            Log.e(ERROR_TAG, "Persistent class not found", csfE);
        }

        return null;
    }

    public void write(String loc, Context appContext, Object obj) {
        try {
            FileOutputStream fileOutputStream = appContext
                    .openFileOutput(loc, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(obj);

            objectOutputStream.close();
        } catch (FileNotFoundException fnfE) {
            Log.e(ERROR_TAG, "Persistent file not found", fnfE);
        } catch (IOException ioE) {
            Log.e(ERROR_TAG, "Persistent object output stream now found", ioE);
        }
    }
}
