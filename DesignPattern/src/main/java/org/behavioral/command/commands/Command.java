package org.behavioral.command.commands;

/**
 * The Command interface defines the method to execute a command and undo a command.
 */
public interface Command
{
    void execute();

    void undo();
}
