package helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

interface ConfigHelper {

    static Properties loadProperties(String fileName){
        Properties prop = new Properties();
        try(InputStream inputStream = ConfigHelper.class.getClassLoader().getResourceAsStream(fileName)) {
            if(inputStream==null){
                throw new RuntimeException("Sorry, unable to find properties: " + fileName);
            }
            prop.load(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
