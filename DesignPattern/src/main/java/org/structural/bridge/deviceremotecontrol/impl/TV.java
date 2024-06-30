package org.structural.bridge.deviceremotecontrol.impl;

/**
 * The TV class provides a concrete implementation for a TV device.
 */
public class TV implements Device
{
    private boolean on;
    private int volume;
    private int channel;

    @Override
    public void powerOn()
    {
        on = true;
        System.out.println("TV is now ON");
    }

    @Override
    public void powerOff()
    {
        on = false;
        System.out.println("TV is now OFF");
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
        System.out.println("TV volume set to " + volume + "%");
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
    public void setChannel(int channel)
    {
        this.channel = channel;
        System.out.println("TV channel set to " + channel);
    }

    @Override
    public int getChannel()
    {
        return channel;
    }
}
