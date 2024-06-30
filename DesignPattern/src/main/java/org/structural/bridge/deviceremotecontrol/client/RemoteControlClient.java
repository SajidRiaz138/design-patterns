package org.structural.bridge.deviceremotecontrol.client;

import org.structural.bridge.deviceremotecontrol.abstraction.AdvancedRemote;
import org.structural.bridge.deviceremotecontrol.abstraction.AdvancedRemoteControl;
import org.structural.bridge.deviceremotecontrol.abstraction.BasicRemoteControl;
import org.structural.bridge.deviceremotecontrol.abstraction.RemoteControl;
import org.structural.bridge.deviceremotecontrol.impl.DVDPlayer;
import org.structural.bridge.deviceremotecontrol.impl.Device;
import org.structural.bridge.deviceremotecontrol.impl.TV;

public class RemoteControlClient
{
    public static void main(String[] args)
    {
        Device tv = new TV();
        RemoteControl basicRemote = new BasicRemoteControl(tv);

        System.out.println("Testing Basic Remote with TV:");
        basicRemote.togglePower();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        basicRemote.channelDown();
        basicRemote.volumeDown();
        basicRemote.togglePower();

        Device dvdPlayer = new DVDPlayer();
        AdvancedRemote advancedRemote = new AdvancedRemoteControl(dvdPlayer);

        System.out.println("\nTesting Advanced Remote with DVD Player:");
        advancedRemote.togglePower();
        advancedRemote.volumeUp();
        advancedRemote.mute();
        advancedRemote.setChannel(5);
        advancedRemote.channelUp();
        advancedRemote.channelDown();
        advancedRemote.volumeDown();
        advancedRemote.togglePower();
    }
}
