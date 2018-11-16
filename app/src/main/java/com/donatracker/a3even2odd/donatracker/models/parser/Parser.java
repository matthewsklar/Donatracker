package com.donatracker.a3even2odd.donatracker.models.parser;

import java.io.InputStream;

/**
 * Abstract class for parsers.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
abstract class Parser<E> {
    /**
     * Path to the location of the file to parse.
     */
    private String loc;

    /**
     * Input stream containing the file at loc.
     */
    private InputStream inputStream;

    /* Getters and Setters */
//    /**
//     * Getter for loc.
//     *
//     * @return getLoc
//     */
//    String getLoc() {
//        return loc;
//    }

    /**
     * Getter for inputStream.
     *
     * @return inputStream
     */
    InputStream getInputStream() {
        return inputStream;
    }

    /**
     * Constructor for Parser.
     *
     * @param inputStream input stream containing the file at loc
     */
    Parser(InputStream inputStream) {
        this("", inputStream);
    }

    /**
     * Constructor for Parser.
     *
     * @param loc path to the location of the file to parse
     * @param inputStream input stream containing the file at loc
     */
    Parser(String loc, InputStream inputStream) {
        this.loc = loc;
        this.inputStream = inputStream;
    }

//    /**
//     * Parse the file into a data class.
//     * @return a list of E
//     */
//    public abstract List<E> Parse();
}
