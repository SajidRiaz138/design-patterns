package org.creational.singleton.enumsingleton;

import org.creational.objectpool.DatabaseConnection;

import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public enum DatabaseConnectionPool
{
    INSTANCE;

    private static final int POOL_SIZE = 10;
    private final BlockingQueue<DatabaseConnection> availableConnections = new LinkedBlockingQueue<>(POOL_SIZE);
    private final String url = "jdbc:mysql://localhost:3306/classicmodels";
    private final String user = "root";
    private final String password = "root";

    DatabaseConnectionPool()
    {
        for (int i = 0; i < POOL_SIZE; i++)
        {
            try
            {
                availableConnections.add(new DatabaseConnection(url, user, password));
            }
            catch (SQLException e)
            {
                throw new RuntimeException("Error initializing the connection pool", e);
            }
        }
    }

    public DatabaseConnection acquireConnection() throws InterruptedException
    {
        return availableConnections.take();
    }

    public void releaseConnection(DatabaseConnection connection)
    {
        try
        {
            availableConnections.put(connection);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown()
    {
        while (!availableConnections.isEmpty())
        {
            try
            {
                availableConnections.take().close();
            }
            catch (SQLException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        try
        {
            DatabaseConnectionPool pool = DatabaseConnectionPool.INSTANCE;

            // Acquire a connection from the pool
            DatabaseConnection connection1 = pool.acquireConnection();
            System.out.println("Acquired connection 1: " + connection1.getConnection());

            // Use the connection...

            // Release the connection back to the pool
            pool.releaseConnection(connection1);
            System.out.println("Released connection 1");

            // Acquire another connection from the pool
            DatabaseConnection connection2 = pool.acquireConnection();
            System.out.println("Acquired connection 2: " + connection2.getConnection());

            // Use the connection...

            // Release the connection back to the pool
            pool.releaseConnection(connection2);
            System.out.println("Released connection 2");

            // Shutdown the pool
            pool.shutdown();
            System.out.println("Pool shutdown");

        }
        catch (InterruptedException exception)
        {
            exception.printStackTrace();
        }
    }
}
