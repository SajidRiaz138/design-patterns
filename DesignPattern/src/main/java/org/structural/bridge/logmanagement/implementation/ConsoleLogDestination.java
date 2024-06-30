package org.structural.bridge.logmanagement.implementation;

/**
 * The ConsoleLogDestination class provides a concrete implementation for logging to the console.
 */
public class ConsoleLogDestination implements LogDestination
{
    @Override
    public void sendLog(String formattedMessage)
    {
        System.out.println("Console Log: " + formattedMessage);
    }
}
