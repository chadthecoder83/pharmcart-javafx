package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager.showLogin(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}