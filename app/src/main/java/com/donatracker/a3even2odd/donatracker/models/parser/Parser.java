package com.donatracker.a3even2odd.donatracker.models.parser;

import java.io.InputStream;
import java.util.List;

/**
 * Abstract class for parsers.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public abstract class Parser<E> {
    /**
     * Path to the location of the file to parse.
     */
    private String loc;

    /**
     * Input stream containing the file at loc.
     */
    private InputStream inputStream;

    /* Getters and Setters */
    /**
     * Getter for loc.
     *
     * @return getLoc
     */
    String getLoc() {
        return loc;
    }

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
    public Parser(InputStream inputStream) {
        this("", inputStream);
    }

    /**
     * Constructor for Parser.
     *
     * @param loc path to the location of the file to parse
     * @param inputStream input stream containing the file at loc
     */
    public Parser(String loc, InputStream inputStream) {
        this.loc = loc;
        this.inputStream = inputStream;
    }

    /**
     * Parse the file into a data class.
     */
    public abstract List<E> Parse();
}
