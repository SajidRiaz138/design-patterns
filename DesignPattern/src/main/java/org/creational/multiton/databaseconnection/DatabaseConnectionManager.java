package org.creational.multiton.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.EnumMap;
import java.util.Map;

/**
 * DatabaseConnectionManager class implements the Multiton pattern for managing
 * database connections for different database types. This ensures that there is
 * only one connection manager instance for each database type.
 */
public class DatabaseConnectionManager
{
    private static final Map<DatabaseType, DatabaseConnectionManager> instances = new EnumMap<>(DatabaseType.class);
    private final DatabaseType databaseType;
    private final Connection connection;

    private DatabaseConnectionManager(DatabaseType databaseType)
    {
        this.databaseType = databaseType;
        this.connection = ConnectionFactory.createConnection(databaseType);
    }

    /**
     * Returns the singleton instance of DatabaseConnectionManager for the given database type.
     * If an instance does not already exist, it will be created.
     *
     * @param databaseType the database type for which to get the connection manager.
     * @return the singleton instance of DatabaseConnectionManager for the given database type.
     */
    public static DatabaseConnectionManager getInstance(DatabaseType databaseType)
    {
        return instances.computeIfAbsent(databaseType, DatabaseConnectionManager::new);
    }

    /**
     * Returns the connection for the database type.
     *
     * @return the connection.
     */
    public Connection getConnection()
    {
        return connection;
    }

    @Override
    public String toString()
    {
        return "DatabaseConnectionManager{" +
                "databaseType=" + databaseType +
                ", connection=" + connection +
                '}';
    }

    public static void main(String[] args)
    {
        DatabaseConnectionManager mysqlManager = DatabaseConnectionManager.getInstance(DatabaseType.MYSQL);
        System.out.println("MySQL Connection: " + mysqlManager.getConnection());

        DatabaseConnectionManager postgresManager = DatabaseConnectionManager.getInstance(DatabaseType.POSTGRESQL);
        System.out.println("PostgreSQL Connection: " + postgresManager.getConnection());

        DatabaseConnectionManager mongoManager = DatabaseConnectionManager.getInstance(DatabaseType.MONGODB);
        System.out.println("MongoDB Connection: " + mongoManager.getConnection());

        // Verify that the same instance is returned for the same database type
        DatabaseConnectionManager anotherMysqlManager = DatabaseConnectionManager.getInstance(DatabaseType.MYSQL);
        System.out.println("Another MySQL Manager: " + anotherMysqlManager);
        System.out.println("Is the same instance: " + (mysqlManager == anotherMysqlManager));
    }
}
