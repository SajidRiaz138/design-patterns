package org.behavioral.command.commands;

import org.behavioral.command.receiver.Light;

/**
 * The LightOnCommand class turns on the light.
 */
public class LightOnCommand implements Command
{
    private Light light;

    public LightOnCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute()
    {
        light.on();
    }

    @Override
    public void undo()
    {
        light.off();
    }
}
