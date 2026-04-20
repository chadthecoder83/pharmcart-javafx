package ui;

import dao.UserDao;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        Button registerButton = new Button("Register");

        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Username and password cannot be empty");
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

        registerButton.setOnAction(e -> messageLabel.setText("Register feature coming soon"));

        VBox root = new VBox(10,
                titleLabel,
                new Label("Username"),
                usernameField,
                new Label("Password"),
                passwordField,
                loginButton,
                registerButton,
                messageLabel
        );
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 320, 300));
        stage.setTitle("PharmCart Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}