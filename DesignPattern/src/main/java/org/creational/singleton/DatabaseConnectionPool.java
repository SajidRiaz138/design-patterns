package org.creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnectionPool implements AutoCloseable
{
    private static volatile DatabaseConnectionPool instance;
    private static final Logger logger = Logger.getLogger(DatabaseConnectionPool.class.getName());
    private BlockingQueue<Connection> connectionPool;
    private final String url;
    private final String user;
    private final String password;
    private final int poolSize;

    private DatabaseConnectionPool(String url, String user, String password, int poolSize)
    {
        this.url = url;
        this.user = user;
        this.password = password;
        this.poolSize = poolSize;
        initializePool();
    }

    public static DatabaseConnectionPool getInstance(String url, String user, String password, int poolSize)
    {
        DatabaseConnectionPool result = instance;
        if (result == null)
        {
            synchronized (DatabaseConnectionPool.class)
            {
                result = instance;
                if (result == null)
                {
                    instance = result = new DatabaseConnectionPool(url, user, password, poolSize);
                }
            }
        }
        return result;
    }

    private void initializePool()
    {
        connectionPool = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++)
        {
            connectionPool.add(createNewConnection());
        }
    }

    private Connection createNewConnection()
    {
        try
        {
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Failed to create a new database connection", e);
        }
    }

    public Connection getConnection()
    {
        try
        {
            Connection connection = connectionPool.take();
            if (!isConnectionValid(connection))
            {
                connection = createNewConnection();
            }
            return connection;
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Failed to retrieve a connection from the pool", e);
        }
    }

    public void releaseConnection(Connection connection)
    {
        if (connection != null)
        {
            try
            {
                if (!isConnectionValid(connection))
                {
                    connection = createNewConnection();
                }
                connectionPool.offer(connection);
            }
            catch (Exception e)
            {
                logger.log(Level.SEVERE, "Failed to validate connection", e);
                // If validation fails, we don't add the connection back to the pool
            }
        }
    }

    private boolean isConnectionValid(Connection connection)
    {
        try
        {
            return connection != null && !connection.isClosed() && connection.isValid(2);
        }
        catch (SQLException e)
        {
            logger.log(Level.SEVERE, "Failed to validate connection", e);
            return false;
        }
    }

    @Override
    public void close()
    {
        synchronized (DatabaseConnectionPool.class)
        {
            while (!connectionPool.isEmpty())
            {
                try
                {
                    connectionPool.take().close();
                }
                catch (SQLException e)
                {
                    logger.log(Level.SEVERE, "Failed to close connection", e);
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                    logger.log(Level.SEVERE, "Interrupted while closing connections", e);
                }
            }
        }
    }
}
