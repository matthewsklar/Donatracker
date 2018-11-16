package com.donatracker.a3even2odd.donatracker.models.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to parse CSV file.
 *
 * @author Matt Sklar
 */
public final class CsvParser extends Parser {
    /**
     * Constructor for Parser
     *
     * @param inputStream input stream containing the file at loc
     */
    public CsvParser(InputStream inputStream) {
        super(inputStream);
    }

    /**
     * Parse the file into a data class.
     * @return a list of strings.
     */
    //@Override
    public List<String[]> Parse() {
        InputStream inputStream = getInputStream();

        List<String[]> resultList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine = reader.readLine();

            while (csvLine != null) {
                String[] row = csvLine.split(",");

                resultList.add(row);
                csvLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error in reading CSV file: " + e);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Error while closing input stream: " + e);
        }

        return resultList;
    }
}
