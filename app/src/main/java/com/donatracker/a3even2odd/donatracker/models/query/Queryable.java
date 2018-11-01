package com.donatracker.a3even2odd.donatracker.models.query;

import java.util.List;

/**
 * An interface for objects that can be queried.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public interface Queryable {
    /**
     * Collect all of the data that can be queried through for the object.
     *
     * The data must be entered in the same order it is entered from the query.
     *
     * @return the data that can be queried
     */
    List<String> queryData();
}
