package test.java.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private Properties properties;
    private final String propertyFilePath = "src\\test\\java\\resources\\configuration.properties";

    public PropertyManager(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getPropertyValue(String value) {
        String url = properties.getProperty(value);
        if(url != null)
            return url;
        else
            throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
}
