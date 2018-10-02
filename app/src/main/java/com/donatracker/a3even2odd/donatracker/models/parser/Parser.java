package com.donatracker.a3even2odd.donatracker.models.parser;

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
    protected String loc;

    /**
     * Constructor for Parser
     *
     * @param loc path to the location of the file to parse
     */
    public Parser(String loc) {
        this.loc = loc;
    }

    /**
     * Get the file and store its contents as a String.
     *
     * @return the contents of the file at loc
     */
    protected String getFile() {
        // TODO: Implement this class
        return "TODO: IMPLEMENT THIS";
    }

    /**
     * Parse the file into a data class.
     */
    public abstract void Parse();
}
