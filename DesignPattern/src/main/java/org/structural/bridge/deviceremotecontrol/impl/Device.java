package org.structural.bridge.deviceremotecontrol.impl;

/**
 * The Device interface defines the operations that can be performed on a device.
 */
public interface Device
{
    void powerOn();

    void powerOff();

    void setVolume(int percent);

    int getVolume();

    boolean isEnabled();

    void setChannel(int channel);

    int getChannel();
}
