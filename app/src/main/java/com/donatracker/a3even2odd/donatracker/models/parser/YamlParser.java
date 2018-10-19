package com.donatracker.a3even2odd.donatracker.models.parser;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Parse YAML files and store data in data class.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class YamlParser extends Parser {
    /**
     * Constructor for Parser
     *
     * @param inputStream input stream containing the file at loc
     */
    public YamlParser(InputStream inputStream) {
        super(inputStream);
    }

    // TODO: Rewrite these comments
    /**
     * Parse the file into a data class.
     */
    @Override
    public List<Float> Parse() {
        Yaml yaml = new Yaml();

        InputStream inputStream = getInputStream();

        LinkedHashMap data = (LinkedHashMap) yaml.load(inputStream);

        List<Float> valList = new ArrayList<>();

        for (Object o : data.values()) {
            valList.add((float) Math.round((double) o));
        }

        return valList;
    }
}
