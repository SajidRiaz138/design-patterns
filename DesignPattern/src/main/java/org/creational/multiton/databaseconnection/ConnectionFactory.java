package org.creational.multiton.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{
    /**
     * Creates a new connection for the given database type.
     * In a real application, this would typically involve loading connection details from a configuration file.
     *
     * @param databaseType the database type for which to create the connection.
     * @return the created connection.
     */
    public static Connection createConnection(DatabaseType databaseType)
    {
        String url = null;
        String user = "user";
        String password = "password";

        switch (databaseType)
        {
            case MYSQL:
                url = "jdbc:mysql://localhost:3306/mydatabase";
                break;
            case POSTGRESQL:
                url = "jdbc:postgresql://localhost:5432/mydatabase";
                break;
            case MONGODB:
                // MongoDB uses a different connection approach, typically with a MongoClient
                // Here, we just simulate it with a dummy connection object
                url = "jdbc:mongodb://localhost:27017/mydatabase";
                break;
            default:
                throw new IllegalArgumentException("Unknown database type: " + databaseType);
        }

        try
        {
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Failed to create connection for " + databaseType, e);
        }
    }
}
