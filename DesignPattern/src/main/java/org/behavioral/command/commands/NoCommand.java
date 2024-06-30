package org.behavioral.command.commands;

/**
 * The NoCommand class is a null object pattern to avoid null checks.
 */
public class NoCommand implements Command
{
    @Override
    public void execute()
    {
    }

    @Override
    public void undo()
    {
    }
}
