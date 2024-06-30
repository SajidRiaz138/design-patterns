package org.structural.bridge.deviceremotecontrol.abstraction;

/**
 * The RemoteControl interface defines the basic operations for a remote control.
 */
public interface RemoteControl
{
    void togglePower();

    void volumeUp();

    void volumeDown();

    void channelUp();

    void channelDown();
}
