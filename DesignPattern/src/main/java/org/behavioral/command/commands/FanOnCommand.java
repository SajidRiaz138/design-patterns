package org.behavioral.command.commands;

import org.behavioral.command.receiver.Fan;

/**
 * The FanOnCommand class turns on the fan.
 */
public class FanOnCommand implements Command
{
    private Fan fan;

    public FanOnCommand(Fan fan)
    {
        this.fan = fan;
    }

    @Override
    public void execute()
    {
        fan.on();
    }

    @Override
    public void undo()
    {
        fan.off();
    }
}
