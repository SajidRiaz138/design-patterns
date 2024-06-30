package org.creational.objectpool;

import java.sql.SQLException;

public class client
{
    public static void main(String[] args)
    {
        PropertiesLoader propertiesLoader = new PropertiesLoader("config.properties");
        String url = propertiesLoader.getProperty("db.url");
        String user = propertiesLoader.getProperty("db.user");
        String password = propertiesLoader.getProperty("db.password");

        try
        {
            DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance(url, user, password);

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
        catch (SQLException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
