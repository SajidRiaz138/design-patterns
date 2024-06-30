package org.structural.bridge.deviceremotecontrol.abstraction;

import org.structural.bridge.deviceremotecontrol.impl.Device;

/**
 * The AdvancedRemoteControl class implements the AdvancedRemote interface and adds additional features.
 */
public class AdvancedRemoteControl extends BasicRemoteControl implements AdvancedRemote
{
    public AdvancedRemoteControl(Device device)
    {
        super(device);
    }

    @Override
    public void mute()
    {
        device.setVolume(0);
        System.out.println("Device muted");
    }

    @Override
    public void setChannel(int channel)
    {
        device.setChannel(channel);
        System.out.println("Channel set to " + channel);
    }
}
