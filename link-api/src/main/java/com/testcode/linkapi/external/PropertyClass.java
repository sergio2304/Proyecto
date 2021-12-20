package com.testcode.linkapi.external;


import java.io.FileInputStream;
import java.util.Properties;

public  class PropertyClass {

    public static String getProperty(String property) {
        FileInputStream propertyFile = null;
        Properties properties = new Properties();

        try {
            propertyFile = new FileInputStream("src/main/java/com/testcode/linkapi/external/service.properties");
            properties.load(propertyFile);
        } catch (Exception e) {
            System.out.println("Error reading service.properties." + e);
        } finally {
            try {
                propertyFile.close();
            } catch (Exception e) {
                System.out.println("File close error " + e);
            }
        }
        return properties.getProperty(property);
    }
}
