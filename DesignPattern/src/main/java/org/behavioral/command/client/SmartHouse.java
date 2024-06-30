package org.behavioral.command.client;

import org.behavioral.command.commands.Command;
import org.behavioral.command.commands.FanOffCommand;
import org.behavioral.command.commands.FanOnCommand;
import org.behavioral.command.commands.LightOffCommand;
import org.behavioral.command.commands.LightOnCommand;
import org.behavioral.command.commands.MacroCommand;
import org.behavioral.command.commands.NoCommand;
import org.behavioral.command.commands.ThermostatSetTemperatureCommand;
import org.behavioral.command.invoker.RemoteControl;
import org.behavioral.command.receiver.Fan;
import org.behavioral.command.receiver.Light;
import org.behavioral.command.receiver.Thermostat;

public class SmartHouse
{
    public static void main(String[] args)
    {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Fan ceilingFan = new Fan("Ceiling");
        Thermostat thermostat = new Thermostat();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        FanOnCommand fanOn = new FanOnCommand(ceilingFan);
        FanOffCommand fanOff = new FanOffCommand(ceilingFan);
        ThermostatSetTemperatureCommand setTemp = new ThermostatSetTemperatureCommand(thermostat, 25);

        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, fanOn, fanOff);
        remote.setCommand(3, setTemp, new NoCommand());

        remote.onButtonPressed(0);
        remote.offButtonPressed(0);
        remote.undoButtonPressed();

        remote.onButtonPressed(1);
        remote.offButtonPressed(1);
        remote.undoButtonPressed();

        remote.onButtonPressed(2);
        remote.offButtonPressed(2);
        remote.undoButtonPressed();

        remote.onButtonPressed(3);
        remote.undoButtonPressed();

        // Schedule a command
        remote.scheduleCommand(new LightOnCommand(kitchenLight), 5000);

        // Create a macro command
        Command[] partyMode = { livingRoomLightOn, kitchenLightOn, fanOn, setTemp };
        MacroCommand partyMacro = new MacroCommand(partyMode);
        remote.setCommand(4, partyMacro, new NoCommand());
        remote.onButtonPressed(4);
        remote.undoButtonPressed();

        // Stop the scheduler before exit
        remote.stopScheduler();
    }
}
