package org.behavioral.command.invoker;

import org.behavioral.command.commands.Command;
import org.behavioral.command.commands.NoCommand;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * The RemoteControl class acts as the invoker, storing and executing commands.
 */
public class RemoteControl
{
    private static final Logger logger = Logger.getLogger(RemoteControl.class.getName());
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> commandHistory;
    private Timer scheduler;

    public RemoteControl()
    {
        onCommands = new Command[5];
        offCommands = new Command[5];
        commandHistory = new Stack<>();
        scheduler = new Timer();

        Command noCommand = new NoCommand();
        for (int i = 0; i < 5; i++)
        {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand)
    {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPressed(int slot)
    {
        onCommands[slot].execute();
        commandHistory.push(onCommands[slot]);
        logger.info("Executed ON command in slot " + slot);
    }

    public void offButtonPressed(int slot)
    {
        offCommands[slot].execute();
        commandHistory.push(offCommands[slot]);
        logger.info("Executed OFF command in slot " + slot);
    }

    public void undoButtonPressed()
    {
        if (!commandHistory.isEmpty())
        {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
            logger.info("Undid the last command");
        }
    }

    public void scheduleCommand(Command command, long delay)
    {
        scheduler.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                command.execute();
                commandHistory.push(command);
                logger.info("Scheduled command executed");
            }
        }, delay);
    }

    public void stopScheduler()
    {
        scheduler.cancel();
        logger.info("Scheduler stopped");
    }
}
