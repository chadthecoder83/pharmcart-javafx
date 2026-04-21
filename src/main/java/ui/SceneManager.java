package ui;

import javafx.stage.Stage;

public class SceneManager {

    public static void showLogin(Stage stage) {
        try {
            new LoginView().start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showProducts(Stage stage) {
        try {
            new ProductView().start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showAdmin(Stage stage) {
        try {
            new AdminInventoryView().start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}