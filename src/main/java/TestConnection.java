import database.DatabaseConnection;
import database.DatabaseInitializer;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.connect()) {
            if (conn != null) {
                System.out.println("Connected to database!");
                DatabaseInitializer.initializeDatabase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}