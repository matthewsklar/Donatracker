package com.donatracker.a3even2odd.donatracker.models.login;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class LoginSingleton {
    private static final LoginSingleton ourInstance = new LoginSingleton();

    public static LoginSingleton getInstance() {
        return ourInstance;
    }

    /**
     * Amount of login attempts done in the current time frame.
     */
    private int loginAttempts;

    /**
     * Data relating to lockout protocol
     */
    private LockoutData lockoutData;

    /* Getters and Setters */
    /**
     * Getter for loginAttempts.
     *
     * @return loginAttempts
     */
    public int getLoginAttempts() {
        return loginAttempts;
    }

    /**
     * Setter for loginAttempts.
     *
     * @param loginAttempts
     */
    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    /**
     * Getter for lockoutData
     *
     * @return lockoutData
     */
    public LockoutData getLockoutData() {
        return lockoutData;
    }

    private LoginSingleton() {
        lockoutData = new LockoutData();

        //loadYaml("../configs/login_config.yaml");
    }

    /**
     * Load the YAML config and store it in a LockoutData object
     *
     * @param loc the location of the YAML file
     */
    public void loadYaml(String loc) {
        Yaml yaml = new Yaml();

        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(loc);

        /*FileInputStream inputStream;

        try {
            inputStream = new FileInputStream(loc);
        } catch (java.io.FileNotFoundException e) {
            inputStream = null;
        }*/

        //this.lockoutData = inputStream;
        lockoutData = (LockoutData) yaml.load(inputStream);

        /*Yaml yaml = new Yaml();
        String document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae";
        List<String> list = (List<String>) yaml.load(document);*/
    }
}
