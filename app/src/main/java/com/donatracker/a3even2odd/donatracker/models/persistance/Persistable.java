package com.donatracker.a3even2odd.donatracker.models.persistance;

import java.util.List;

/**
 * Interface for objects that persist between iterations of the app.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public interface Persistable<E> {
    /**
     * Access the persistant data and load it into the object.
     *
     * @param e the saved instance of the class that is to be loaded
     */
    //void load(E e);


    List<E> getPersistentData();
}
