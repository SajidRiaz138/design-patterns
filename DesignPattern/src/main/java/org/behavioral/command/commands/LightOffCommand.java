package org.behavioral.command.commands;

import org.behavioral.command.receiver.Light;

/**
 * The LightOffCommand class turns off the light.
 */
public class LightOffCommand implements Command
{
    private Light light;

    public LightOffCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute()
    {
        light.off();
    }

    @Override
    public void undo()
    {
        light.on();
    }
}
