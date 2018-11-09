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

        if (emptyQuery(data)) queriedList.addAll(queryList);
        else {
            for (int i = 0; i < queryList.size(); i++) {
                E e = queryList.get(i);
                boolean meetsReq = false;
                for (int j = 0; j < data.size(); j++) {
                    String query = data.get(j);

                    if (!query.equals("")) {
                        if (e.queryData().get(j).toLowerCase()
                                .contains(query.toLowerCase())) {
                            meetsReq = true;
                        } else {
                            meetsReq = false;
                            break;
                        }
                    }
                }
                if (meetsReq) {
                    queriedList.addLast(e);
                }
            }
        }

        return queriedList;
    }

    /**
     * Check if the query has no parameters.
     *
     * @param data the query data
     * @return if the query contains no data
     */
    private boolean emptyQuery(List<String> data) {
        for (String s : data) {
            if (!s.equals("")) return false;
        }

        return true;
    }
}
