package org.behavioral.command.receiver;

/**
 * The Light class represents a light that can be turned on or off.
 */
public class Light
{
    private String location;
    private boolean isOn;

    public Light(String location)
    {
        this.location = location;
        this.isOn = false;
    }

    public void on()
    {
        isOn = true;
        System.out.println(location + " light is ON");
    }

    public void off()
    {
        isOn = false;
        System.out.println(location + " light is OFF");
    }

    public boolean isOn()
    {
        return isOn;
    }
}
