package org.creational.objectpool;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DatabaseConnectionPool
{
    private final BlockingQueue<DatabaseConnection> availableConnections;
    private final Set<DatabaseConnection> usedConnections = new HashSet<>();
    private final String url;
    private final String user;
    private final String password;
    private static final int INITIAL_POOL_SIZE = 10;
    private static volatile DatabaseConnectionPool instance;
    private static final Object lock = new Object();

    private DatabaseConnectionPool(String url, String user, String password) throws SQLException
    {
        this.url = url;
        this.user = user;
        this.password = password;
        availableConnections = new LinkedBlockingQueue<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++)
        {
            availableConnections.add(createConnection());
        }
    }

    public static DatabaseConnectionPool getInstance(String url, String user, String password) throws SQLException
    {
        DatabaseConnectionPool result = instance;
        if (result == null)
        {
            synchronized (DatabaseConnectionPool.class)
            {
                result = instance;
                if (result == null)
                {
                    instance = result = new DatabaseConnectionPool(url, user, password);
                }
            }
        }
        return result;
    }

    private DatabaseConnection createConnection() throws SQLException
    {
        return new DatabaseConnection(url, user, password);
    }

    public DatabaseConnection acquireConnection() throws InterruptedException, SQLException
    {
        synchronized (lock)
        {
            if (availableConnections.isEmpty() && usedConnections.size() < INITIAL_POOL_SIZE)
            {
                availableConnections.add(createConnection());
            }
            DatabaseConnection connection = availableConnections.take();
            usedConnections.add(connection);
            return connection;
        }
    }

    public void releaseConnection(DatabaseConnection connection) throws SQLException
    {
        synchronized (lock)
        {
            if (usedConnections.remove(connection))
            {
                availableConnections.offer(connection);
            }
            else
            {
                connection.close();
            }
        }
    }

    public void shutdown() throws SQLException
    {
        synchronized (lock)
        {
            for (DatabaseConnection connection : availableConnections)
            {
                connection.close();
            }
            for (DatabaseConnection connection : usedConnections)
            {
                connection.close();
            }
        }
    }
}
