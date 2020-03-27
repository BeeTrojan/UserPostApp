package org.trojanowski.config;

import org.trojanowski.Application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties loadPropertiesFile(String fileName) {
        InputStream propertiesFile = Application.class.getClassLoader().getResourceAsStream(fileName);
        Properties properties = new Properties();

        try {
            if (propertiesFile == null) {
                throw new FileNotFoundException();
            }
            properties.load(propertiesFile);

        } catch (IOException e) {
            System.out.println("Problem with load configuration file, make sure you typed correct file name.");
            e.printStackTrace();
        }
        return properties;
    }
}