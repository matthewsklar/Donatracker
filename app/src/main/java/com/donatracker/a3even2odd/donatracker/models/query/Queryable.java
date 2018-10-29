package com.donatracker.a3even2odd.donatracker.models.query;

import java.util.List;

public interface Queryable {
    /**
     * Collect all of the data that can be queried through for the object.
     *
     * @return the data that can be queried
     */
    List<String> queryData();
}
