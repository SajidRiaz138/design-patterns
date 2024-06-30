package org.creational.multiton.modulelogger;

import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * LoggerManager class implements the Multiton pattern for managing loggers
 * for different modules. This ensures that there is only one logger instance
 * for each module.
 */
public class LoggerManager
{
    private static final Map<Module, LoggerManager> instances = new EnumMap<>(Module.class);
    private final Module module;
    private final Logger logger;

    private LoggerManager(Module module)
    {
        this.module = module;
        this.logger = Logger.getLogger(module.name());
    }

    /**
     * Returns the singleton instance of LoggerManager for the given module.
     * If an instance does not already exist, it will be created.
     *
     * @param module the module for which to get the logger manager.
     * @return the singleton instance of LoggerManager for the given module.
     */
    public static LoggerManager getInstance(Module module)
    {
        return instances.computeIfAbsent(module, LoggerManager::new);
    }

    /**
     * Logs a message at the specified level.
     *
     * @param level   the level at which to log the message.
     * @param message the message to log.
     */
    public void log(Level level, String message)
    {
        logger.log(level, message);
    }

    @Override
    public String toString()
    {
        return "LoggerManager{" +
                "module=" + module +
                ", logger=" + logger.getName() +
                '}';
    }

    public static void main(String[] args)
    {
        LoggerManager authLogger = LoggerManager.getInstance(Module.AUTHENTICATION);
        authLogger.log(Level.INFO, "Authentication module started.");

        LoggerManager paymentLogger = LoggerManager.getInstance(Module.PAYMENTS);
        paymentLogger.log(Level.INFO, "Payment processing initiated.");

        LoggerManager notificationLogger = LoggerManager.getInstance(Module.NOTIFICATIONS);
        notificationLogger.log(Level.WARNING, "Notification service delay detected.");

        // Verify that the same instance is returned for the same module
        LoggerManager anotherAuthLogger = LoggerManager.getInstance(Module.AUTHENTICATION);
        anotherAuthLogger.log(Level.INFO, "Another log for the authentication module.");
        System.out.println("Is the same instance: " + (authLogger == anotherAuthLogger));
    }
}
