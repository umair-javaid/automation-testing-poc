package com.softech.wlcms.steps.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by umair.javaid on 5/4/2016.
 */
public class WlcmsTestDataFromProperties {

    private InputStream ioStream;

    public String getWlcmsTestDataFromProperty(String wlcmsCurrentEnvironment, String propertyKey) {
        String propertyValue = null;

        {
            try {
                Properties props = new Properties();
                String propsFilePath = "testdata/" + wlcmsCurrentEnvironment
                        + "/wlcms-test-data-" + wlcmsCurrentEnvironment + ".properties";

                ioStream = getClass().getClassLoader().getResourceAsStream(propsFilePath);

                if (ioStream != null) {
                    props.load(ioStream);
                } else {
                    throw new FileNotFoundException("Property File '" + propsFilePath + "' not found in the classpath");
                }

                propertyValue = props.getProperty(propertyKey);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }

            return propertyValue;
        }
    }
}