package org.structural.bridge.logmanagement.abstraction;

import org.json.JSONObject;
import org.structural.bridge.logmanagement.implementation.LogDestination;

/**
 * The JsonLogger class provides a concrete implementation for logging messages in JSON format.
 */
public class JsonLogger extends Logger
{
    public JsonLogger(LogDestination destination)
    {
        super(destination);
    }

    @Override
    public void log(String message)
    {
        JSONObject json = new JSONObject();
        json.put("message", message);
        json.put("timestamp", System.currentTimeMillis());
        destination.sendLog(json.toString());
    }
}
