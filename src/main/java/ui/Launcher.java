package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import database.DatabaseInitializer;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        DatabaseInitializer.initializeDatabase();
        SceneManager.showLogin(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}