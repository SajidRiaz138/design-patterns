package org.behavioral.command.receiver;

/**
 * The Thermostat class represents a thermostat that can set the temperature.
 */
public class Thermostat
{
    private int temperature;

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
        System.out.println("Thermostat set to " + temperature + " degrees");
    }

    public int getTemperature()
    {
        return temperature;
    }
}
