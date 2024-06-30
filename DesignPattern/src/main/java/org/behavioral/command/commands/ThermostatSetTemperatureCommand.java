package org.behavioral.command.commands;

import org.behavioral.command.commands.Command;
import org.behavioral.command.receiver.Thermostat;

/**
 * The ThermostatSetTemperatureCommand class sets the temperature of the thermostat.
 */
public class ThermostatSetTemperatureCommand implements Command
{
    private Thermostat thermostat;
    private int temperature;
    private int prevTemperature;

    public ThermostatSetTemperatureCommand(Thermostat thermostat, int temperature)
    {
        this.thermostat = thermostat;
        this.temperature = temperature;
    }

    @Override
    public void execute()
    {
        prevTemperature = thermostat.getTemperature();
        thermostat.setTemperature(temperature);
    }

    @Override
    public void undo()
    {
        thermostat.setTemperature(prevTemperature);
    }
}
