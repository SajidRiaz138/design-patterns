package org.structural.bridge.deviceremotecontrol.abstraction;

import org.structural.bridge.deviceremotecontrol.impl.Device;

/**
 * The BasicRemoteControl class implements the RemoteControl interface and maintains a reference to the device implementor.
 */
public class BasicRemoteControl implements RemoteControl
{
    protected Device device;

    public BasicRemoteControl(Device device)
    {
        this.device = device;
    }

    @Override
    public void togglePower()
    {
        if (device.isEnabled())
        {
            device.powerOff();
        }
        else
        {
            device.powerOn();
        }
    }

    @Override
    public void volumeUp()
    {
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void volumeDown()
    {
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void channelUp()
    {
        device.setChannel(device.getChannel() + 1);
    }

    @Override
    public void channelDown()
    {
        device.setChannel(device.getChannel() - 1);
    }
}
