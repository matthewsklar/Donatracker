package com.donatracker.a3even2odd.donatracker.models.parser;

import com.donatracker.a3even2odd.donatracker.models.login.LockoutData;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
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
     * @param loc         path to the location of the file to parse
     * @param inputStream input stream containing the file at loc
     */
    public YamlParser(String loc, InputStream inputStream) {
        super(loc, inputStream);
    }

    /**
     * Parse the file into a data class.
     */
    @Override
    public List Parse() {
        Yaml yaml = new Yaml();

        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(getLoc());

        /*FileInputStream inputStream;

        try {
            inputStream = new FileInputStream(loc);
        } catch (java.io.FileNotFoundException e) {
            inputStream = null;
        }*/

        //this.lockoutData = inputStream;
        //lockoutData = (LockoutData) yaml.load(inputStream);

        /*Yaml yaml = new Yaml();
        String document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae";
        List<String> list = (List<String>) yaml.load(document);*/

        return null;
    }
}
