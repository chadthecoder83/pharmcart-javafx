package ui;

import javafx.stage.Stage;

public class SceneManager {

    public static void showLogin(Stage stage) {
        try {
            new LoginView().start(stage);
        } catch (Exception e) {
            System.err.println("Error loading login: " + e.getMessage());
        }
    }

    public static void showProducts(Stage stage) {
        try {
            new ProductView().start(stage);
        } catch (Exception e) {
            System.err.println("Error loading products: " + e.getMessage());
        }
    }
}