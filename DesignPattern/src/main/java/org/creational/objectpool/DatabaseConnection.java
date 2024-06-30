package org.creational.objectpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    private Connection connection;

    public DatabaseConnection(String url, String user, String password) throws SQLException
    {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection()
    {
        return connection;
    }

    public void close() throws SQLException
    {
        connection.close();
    }
}
