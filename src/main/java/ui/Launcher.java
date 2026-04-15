package ui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * PharmCart JavaFX Application
 * Course: CST 338
 * @author Elizabeth Leon
 * @since 4-14-26
 * Description: Entry point of the JavaFX application. Loads the initial login scene.
 */
public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager.showLogin(stage);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        launch(args);
    }
}