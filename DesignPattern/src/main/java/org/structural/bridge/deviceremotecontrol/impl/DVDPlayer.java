package org.structural.bridge.deviceremotecontrol.impl;

/**
 * The DVDPlayer class provides a concrete implementation for a DVD player device.
 */
public class DVDPlayer implements Device
{
    private boolean on;
    private int volume;
    private int chapter;

    @Override
    public void powerOn()
    {
        on = true;
        System.out.println("DVD Player is now ON");
    }

    @Override
    public void powerOff()
    {
        on = false;
        System.out.println("DVD Player is now OFF");
    }

    @Override
    public void setVolume(int percent)
    {
        if (percent < 0)
        {
            volume = 0;
        }
        else if (percent > 100)
        {
            volume = 100;
        }
        else
        {
            volume = percent;
        }
        System.out.println("DVD Player volume set to " + volume + "%");
    }

    @Override
    public int getVolume()
    {
        return volume;
    }

    @Override
    public boolean isEnabled()
    {
        return on;
    }

    @Override
    public void setChannel(int chapter)
    {
        this.chapter = chapter;
        System.out.println("DVD Player chapter set to " + chapter);
    }

    @Override
    public int getChannel()
    {
        return chapter;
    }
}
