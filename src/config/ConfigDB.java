package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    // Database configuration (DB)
    private static final String URL = "jdbc:mysql://localhost:3306/module5_test_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Qwe.123*";

    private ConfigDB() { } // Private constructor for utility class.

    // Opens the database connection
    public static Connection openConnection() {
        try {
            Connection objectConnection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database opened successfully.");
            return objectConnection;

        } catch (SQLException error) {
            System.err.println("ERROR: Failed to connect to the database.");
            throw new RuntimeException("Database connection failed. Details: " + error.getMessage(), error); // Will be caught by the caller
        }
    }

    // Safely closes the Connection object
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database closed successfully.\n");
            }
        } catch (SQLException error) {
            System.err.println("ERROR: Failed to close the database connection.");
            System.err.println("Details: " + error.getMessage());
        }
    }
}
