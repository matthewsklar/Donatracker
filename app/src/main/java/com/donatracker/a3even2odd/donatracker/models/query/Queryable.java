package com.donatracker.a3even2odd.donatracker.models.query;

import java.util.List;

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
