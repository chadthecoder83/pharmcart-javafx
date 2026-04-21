/*
 * PharmCart JavaFX Application
 * Course: CST 338
 *
 * @author Elizabeth Leon
 * @since 4/20/26
 * Description:
 * Manages navigation between login, product, admin, and registration screens.
 *
 */
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

    public static void showAdmin(Stage stage) {
        try {
            new AdminInventoryView().start(stage);
        } catch (Exception e) {
            System.err.println("Error loading admin: " + e.getMessage());
        }
    }

    public static void showRegister(Stage stage) {
        try {
            new RegistrationView().start(stage);
        } catch (Exception e) {
            System.err.println("Error loading registration: " + e.getMessage());
        }
    }
}