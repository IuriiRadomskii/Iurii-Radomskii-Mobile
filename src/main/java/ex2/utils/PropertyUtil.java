package ex2.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    public static String get(String propertyName) {
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream("test.properties");
            property.load(inputStream);
            return property.getProperty(propertyName);
        } catch (IOException e) {
            System.err.println("Property file doesn't exist");
        }
        return "";
    }
}