package org.structural.bridge.logmanagement.abstraction;

import org.structural.bridge.logmanagement.implementation.LogDestination;

/**
 * The Logger class defines the abstraction and maintains a reference to the log destination.
 */
public abstract class Logger
{
    protected LogDestination destination;

    protected Logger(LogDestination destination)
    {
        this.destination = destination;
    }

    public abstract void log(String message);
}
