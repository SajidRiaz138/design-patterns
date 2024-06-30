package org.structural.bridge.logmanagement.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The FileLogDestination class provides a concrete implementation for logging to a file.
 */
public class FileLogDestination implements LogDestination
{
    private String filePath;

    public FileLogDestination(String filePath)
    {
        this.filePath = filePath;
    }

    @Override
    public void sendLog(String formattedMessage)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true)))
        {
            writer.write(formattedMessage);
            writer.newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
