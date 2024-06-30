package org.structural.bridge.deviceremotecontrol.abstraction;

/**
 * The AdvancedRemote interface extends RemoteControl and adds additional operations.
 */
public interface AdvancedRemote extends RemoteControl
{
    void mute();

    void setChannel(int channel);
}
