package org.creational.singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabasePoolClient
{
    private static final String CONNECT_URL = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    private static final int POOL_SIZE = 10;

    public static void main(String[] args)
    {
        DatabaseConnectionPool connectionPool = DatabaseConnectionPool.getInstance(
                CONNECT_URL, USER_NAME, PASSWORD, POOL_SIZE);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try
        {
            executorService.submit(() ->
            {
                try (Connection connection = connectionPool.getConnection())
                {
                    try (Statement stmt = connection.createStatement())
                    {
                        // Execute the SQL query
                        ResultSet rs = stmt.executeQuery("SELECT * FROM orderdetails");
                        // Process the results
                        while (rs.next())
                        {
                            int orderNumber = rs.getInt("orderNumber");
                            String productCode = rs.getString("productCode");
                            int quantityOrdered = rs.getInt("quantityOrdered");
                            double priceEach = rs.getDouble("priceEach");
                            int orderLineNumber = rs.getInt("orderLineNumber");

                            // Print the results
                            System.out.println("Order Number: " + orderNumber + ", Product Code: " + productCode +
                                    ", Quantity Ordered: " + quantityOrdered + ", Price Each: " + priceEach +
                                    ", Order Line Number: " + orderLineNumber);
                        }
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            });

            executorService.submit(() ->
            {
                try (Connection connection = connectionPool.getConnection())
                {
                    try (Statement stmt = connection.createStatement())
                    {
                        // Execute some SQL queries
                        stmt.execute("SELECT * FROM orders");
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            });

            executorService.shutdown();
            while (!executorService.isTerminated())
            {
                // Wait for all tasks to finish
            }
        }
        finally
        {
            connectionPool.close();
        }
    }
}
