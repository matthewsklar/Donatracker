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
    public List<E> query(List<String> data, List<E> queryList) {
        LinkedList<E> queriedList = new LinkedList<>();

        for (E e : queryList) {
            for (String s : e.queryData()) {
                if (data.contains(s)) {
                    queriedList.addLast(e);

                    break;
                }
            }
        }

        return queriedList;
    }
}
