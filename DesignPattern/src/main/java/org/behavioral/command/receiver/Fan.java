package org.behavioral.command.receiver;

/**
 * The Fan class represents a fan that can be turned on or off.
 */
public class Fan
{
    private String location;
    private boolean isOn;

    public Fan(String location)
    {
        this.location = location;
        this.isOn = false;
    }

    public void on()
    {
        isOn = true;
        System.out.println(location + " fan is ON");
    }

    public void off()
    {
        isOn = false;
        System.out.println(location + " fan is OFF");
    }

    public boolean isOn()
    {
        return isOn;
    }
}
