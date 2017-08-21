package com.softech.wlcms.steps.utils;

import com.softech.wlcms.steps.common.WlcmsLoginSteps;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class WlcmsUserCredentialsFromProperties {

    private InputStream ioStream;

    public String getWlcmsUserProperty(String wlcmsCurrentEnvironment,String propertyKey) {
        String propertyValue = null;
        try {
            Properties props = new Properties();



            String propsFilePath = "usercredentials/" + wlcmsCurrentEnvironment
                    + "/user-credentials-" + wlcmsCurrentEnvironment + ".properties";


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
