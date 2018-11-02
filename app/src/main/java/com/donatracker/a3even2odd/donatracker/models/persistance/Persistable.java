package com.donatracker.a3even2odd.donatracker.models.persistance;

import java.util.Collection;

/**
 * Interface for objects that persist between iterations of the app.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public interface Persistable<E> {
    /**
     * Get the data that will be saved to persist between separate instances of the app.
     *
     * @return all the data that will be saved
     */
    Collection<E> getPersistentData();
}
