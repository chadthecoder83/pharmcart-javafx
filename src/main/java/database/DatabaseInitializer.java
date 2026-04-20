package database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {

        String createUsersTable = """
                CREATE TABLE IF NOT EXISTS users (
                    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL
                );
                """;

        String createProductsTable = """
                CREATE TABLE IF NOT EXISTS products (
                    product_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    category TEXT NOT NULL,
                    price REAL NOT NULL,
                    quantity_in_stock INTEGER NOT NULL
                );
                """;

        String createOrdersTable = """
                CREATE TABLE IF NOT EXISTS orders (
                    order_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    user_id INTEGER NOT NULL,
                    product_id INTEGER NOT NULL,
                    quantity INTEGER NOT NULL,
                    total_price REAL NOT NULL,
                    status TEXT NOT NULL,
                    created_at TEXT NOT NULL,
                    FOREIGN KEY (user_id) REFERENCES users(user_id),
                    FOREIGN KEY (product_id) REFERENCES products(product_id)
                );
                """;

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()) {

            // Create tables
            stmt.execute(createUsersTable);
            stmt.execute(createProductsTable);
            stmt.execute(createOrdersTable);

            // Seed Users (admin + regular user)
            stmt.execute("""
                    INSERT OR IGNORE INTO users(username, password, role)
                    VALUES ('admin', 'admin123', 'admin');
                    """);

            stmt.execute("""
                    INSERT OR IGNORE INTO users(username, password, role)
                    VALUES ('user', 'user123', 'user');
                    """);

            // Seed Products
            stmt.execute("""
                    INSERT OR IGNORE INTO products(product_id, name, category, price, quantity_in_stock)
                    VALUES (1, 'Tylenol', 'Pain Relief', 8.99, 25);
                    """);

            stmt.execute("""
                    INSERT OR IGNORE INTO products(product_id, name, category, price, quantity_in_stock)
                    VALUES (2, 'Advil', 'Pain Relief', 7.99, 15);
                    """);

            stmt.execute("""
                    INSERT OR IGNORE INTO products(product_id, name, category, price, quantity_in_stock)
                    VALUES (3, 'Benadryl', 'Allergy', 6.49, 20);
                    """);

            System.out.println("Database initialized successfully with seed data.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}