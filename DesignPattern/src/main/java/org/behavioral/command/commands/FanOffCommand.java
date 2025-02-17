package org.behavioral.command.commands;

import org.behavioral.command.receiver.Fan;

/**
 * The FanOffCommand class turns off the fan.
 */
public class FanOffCommand implements Command
{
    private Fan fan;

    public FanOffCommand(Fan fan)
    {
        this.fan = fan;
    }

    @Override
    public void execute()
    {
        fan.off();
    }

    @Override
    public void undo()
    {
        fan.on();
    }
}
