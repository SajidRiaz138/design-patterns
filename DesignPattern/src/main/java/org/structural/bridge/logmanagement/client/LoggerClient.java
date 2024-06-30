package org.structural.bridge.logmanagement.client;

import org.structural.bridge.logmanagement.abstraction.JsonLogger;
import org.structural.bridge.logmanagement.abstraction.Logger;
import org.structural.bridge.logmanagement.abstraction.XmlLogger;
import org.structural.bridge.logmanagement.implementation.ConsoleLogDestination;
import org.structural.bridge.logmanagement.implementation.FileLogDestination;
import org.structural.bridge.logmanagement.implementation.LogDestination;

public class LoggerClient
{

    public static void main(String... args)
    {
        LogDestination consoleDestination = new ConsoleLogDestination();
        LogDestination fileDestination = new FileLogDestination("logs.txt");

        Logger jsonConsoleLogger = new JsonLogger(consoleDestination);
        Logger xmlFileLogger = new XmlLogger(fileDestination);

        jsonConsoleLogger.log("This is a JSON log message.");
        xmlFileLogger.log("This is an XML log message.");
    }
}
