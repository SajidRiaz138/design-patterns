package org.creational.objectpool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader
{
    private Properties properties = new Properties();

    public PropertiesLoader(String fileName)
    {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName))
        {
            if (input == null)
            {
                System.out.println("Sorry, unable to find " + fileName);
                return;
            }
            properties.load(input);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}
