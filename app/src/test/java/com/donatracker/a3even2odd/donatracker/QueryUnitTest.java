package com.donatracker.a3even2odd.donatracker;

import com.donatracker.a3even2odd.donatracker.models.query.Query;
import com.donatracker.a3even2odd.donatracker.models.query.Queryable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class QueryUnitTest {

    @Test
    public void testQuery() {
        List<String> data1 =  new ArrayList<>();  //query List
            data1.add("location");  //query1
            data1.add("category");  //query2
            data1.add("donation");  //query3

        List<String> data2 = new ArrayList<>();   //an empty data list
            data2.add("");
            data2.add("");
            data2.add("");

        List<String> data3 = new ArrayList<>();
            data3.add("");
            data3.add("category");
            data3.add("donation");

        List<String> queryList1 =  new ArrayList<>();
            queryList1.add("");
            queryList1.add("");
            queryList1.add("");

        List<String> queryList2 =  new ArrayList<>();   //all three parameters
            queryList2.add("location");
            queryList2.add("category");
            queryList2.add("donation");

        List<String> queryList3 =  new ArrayList<>();   //missing a parameter
            queryList3.add("location");
            queryList3.add("category");
            queryList3.add("difference");


        Queryable2 queryable21 = new Queryable2(queryList1);
        Queryable2 queryable22 = new Queryable2(queryList2);
        Queryable2 queryable23 = new Queryable2(queryList3);

        List<Queryable2> query1 = new ArrayList<>();
            query1.add(queryable21);
            query1.add(queryable22);
            query1.add(queryable23);

        Collection<Queryable2> expected1 = new ArrayList<>();
            expected1.add(queryable22);

        Collection<Queryable2> expected2 = new ArrayList<>();
            expected2.add(queryable21);
            expected2.add(queryable22);
            expected2.add(queryable23);

        Collection<Queryable2> expected3 = new ArrayList<>();
            expected3.add(queryable22);


        Query<Queryable2> query11 = new Query<>();
        assertEquals((List)expected1, query11.query(data1, query1));
        assertEquals(query11.query(data2, query1), (List)expected2);
        assertEquals(query11.query(data3, query1), (List)expected3);
    }

    class Queryable2 implements Queryable {
        final List<String> queryList;
        Queryable2(List<String> list) {
            queryList = list;
        }
        public List<String> queryData(){
            return this.queryList;
        }
    }


}