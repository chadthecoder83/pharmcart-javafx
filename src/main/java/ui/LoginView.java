package ui;

import dao.UserDao;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;

public class LoginView extends Application {

    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("PharmCart Login");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");

        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Fields cannot be empty");
                return;
            }

            UserDao userDao = new UserDao();
            User user = userDao.authenticateUser(username, password);

            if (user == null) {
                messageLabel.setText("Invalid username or password");
            } else if ("admin".equalsIgnoreCase(user.getRole())) {
                SceneManager.showAdmin(stage);
            } else {
                SceneManager.showProducts(stage);
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                titleLabel,
                usernameField,
                passwordField,
                loginButton,
                messageLabel
        );

        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("PharmCart Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}