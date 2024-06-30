package org.creational.multiton.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.Map;
import java.util.Properties;

public class Configuration
{
    private static final Map<Environment, Configuration> instances = new EnumMap<>(Environment.class);
    private final Environment environment;
    private final Properties settings = new Properties();

    private Configuration(Environment environment)
    {
        this.environment = environment;
        loadSettings();
    }

    public static Configuration getInstance(Environment environment)
    {
        return instances.computeIfAbsent(environment, Configuration::new);
    }

    private void loadSettings()
    {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties"))
        {
            if (input == null)
            {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            settings.load(input);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public String getSetting(String key)
    {
        return settings.getProperty(environment.name().toLowerCase() + "." + key);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Configuration{");
        sb.append("environment='").append(environment).append('\'');
        sb.append(", settings={");

        settings.stringPropertyNames()
                .stream()
                .filter(key -> key.startsWith(environment.name().toLowerCase() + "."))
                .forEach(key -> sb.append(key.substring(environment.name().length() + 1))
                        .append("=")
                        .append(settings.getProperty(key))
                        .append(", "));

        // Remove the last comma and space if there were settings added
        if (sb.charAt(sb.length() - 2) == ',')
        {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("}}");
        return sb.toString();
    }

    public static void main(String[] args)
    {
        Configuration devConfig = Configuration.getInstance(Environment.DEVELOPMENT);
        System.out.println("Development Config: " + devConfig);
        System.out.println("Development URL: " + devConfig.getSetting("url"));
        System.out.println("Development DB: " + devConfig.getSetting("db"));

        Configuration testConfig = Configuration.getInstance(Environment.TESTING);
        System.out.println("Testing Config: " + testConfig);
        System.out.println("Testing URL: " + testConfig.getSetting("url"));
        System.out.println("Testing DB: " + testConfig.getSetting("db"));

        Configuration prodConfig = Configuration.getInstance(Environment.PRODUCTION);
        System.out.println("Production Config: " + prodConfig);
        System.out.println("Production URL: " + prodConfig.getSetting("url"));
        System.out.println("Production DB: " + prodConfig.getSetting("db"));

        // Verify that the same instance is returned for the same environment
        Configuration anotherDevConfig = Configuration.getInstance(Environment.DEVELOPMENT);
        System.out.println("Another Development Config: " + anotherDevConfig);
        System.out.println("Is the same instance: " + (devConfig == anotherDevConfig));
    }
}
