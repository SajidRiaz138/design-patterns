package org.structural.bridge.logmanagement.implementation;

/**
 * The LogDestination interface defines the operations that can be performed by a log destination.
 */
public interface LogDestination
{
    void sendLog(String formattedMessage);
}
