package com.donatracker.a3even2odd.donatracker.models.query;

import java.util.LinkedList;
import java.util.List;

/**
 * Query data.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class Query<E extends Queryable> {
    /**
     * Query through the given elements to find which elements contain the given data.
     *
     * Add each element that contains a search element to a list that is returned. The data
     * gathered from the query is compared to the corresponding data in the element. Capitalization
     * does not matter.
     *
     * @param data data to query for
     * @param queryList data to query
     * @return the elements from the queryList that contain parts of the data
     */
    public List<E> query(List<String> data, List<E> queryList) {
        LinkedList<E> queriedList = new LinkedList<>();

        for (int i = 0; i < queryList.size(); i++) {
            E e = queryList.get(i);

            for (int j = 0; j < data.size(); j++) {
                String query = data.get(j);

                if (query != null && !query.equals("") && e.queryData().get(j).toLowerCase()
                        .contains(query.toLowerCase())) {
                    queriedList.addLast(e);

                    break;
                }
            }
        }

        return queriedList;
    }
}
