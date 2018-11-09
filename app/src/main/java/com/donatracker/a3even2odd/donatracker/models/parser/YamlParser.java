package com.donatracker.a3even2odd.donatracker.models.parser;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * Parse the file into a data class.
     */
    @Override
    public List<Float> Parse() {
        Yaml yaml = new Yaml();

        InputStream inputStream = getInputStream();

        Map data = (Map) yaml.load(inputStream);

        List<Float> valList = new ArrayList<>();

        for (Object o : data.values()) {
            valList.add((float) Math.round((double) o));
        }

        return valList;
    }
}
