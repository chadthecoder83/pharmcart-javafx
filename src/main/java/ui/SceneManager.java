/*
 * PharmCart JavaFX Application
 * Course: CST 338
 *
 * Author: Elizabeth Leon
 *
 * Description:
 * Manages navigation between login, products, admin, registration, and cart views.
 *
 * GitHub Issue: #17
 * Branch: elizabeth/cart-checkout-flow
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

    public static void showCart(Stage stage) {
        try {
            new CartView().start(stage);
        } catch (Exception e) {
            System.err.println("Error loading cart: " + e.getMessage());
        }
    }
}