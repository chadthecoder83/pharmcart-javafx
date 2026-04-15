package database;

/*
 * Name: Chadwick Smith
 * Course: CST 338
 * Project: PharmCart - Pharmacy E-Commerce Application
 * Description: Creates the SQLite database connection for the application.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:pharmcart.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}