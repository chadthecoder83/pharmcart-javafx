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

        // Title
        Label titleLabel = new Label("PharmCart Login");

        // Username field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");

        // Password field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");

        // Buttons
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        // Message label
        Label messageLabel = new Label();

        // Login button logic
        loginButton.setOnAction(e -> {

            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            // Basic validation
            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Username and password cannot be empty");
                return;
            }

            // Check database
            UserDao userDao = new UserDao();
            User user = userDao.authenticateUser(username, password);

            if (user == null) {
                messageLabel.setText("Invalid username or password");
            } else if ("admin".equalsIgnoreCase(user.getRole())) {
                messageLabel.setText("Welcome Admin!");
                SceneManager.showAdmin(stage);
            } else {
                messageLabel.setText("Welcome User!");
                SceneManager.showProducts(stage);
            }
        });

        // Register button logic (simple placeholder)
        registerButton.setOnAction(e -> {
            messageLabel.setText("Register feature coming soon");
        });

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                titleLabel,
                new Label("Username"),
                usernameField,
                new Label("Password"),
                passwordField,
                loginButton,
                registerButton,
                messageLabel
        );

        // Scene setup
        Scene scene = new Scene(root, 300, 300);
        stage.setTitle("PharmCart Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}