/*
 * PharmCart JavaFX Application
 * Course: CST 338
 *
 * @author Elizabeth Leon
 * @since 4/20/26
 * Description:
 * Displays the registration screen and allows new users to sign up.
 *
 */

package ui;

import dao.UserDao;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;

public class RegistrationView {

    public void start(Stage stage) {
        Label titleLabel = new Label("PharmCart Registration");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button registerButton = new Button("Register");
        Button backButton = new Button("Back");

        Label message = new Label();

        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                message.setText("Fields cannot be empty");
                return;
            }

            try {
                UserDao userDao = new UserDao();
                boolean success = userDao.insertUser(new User(username, password, "user"));

                if (success) {
                    message.setText("Registered successfully");
                    usernameField.clear();
                    passwordField.clear();
                } else {
                    message.setText("Registration failed");
                }
            } catch (Exception ex) {
                message.setText("Registration failed");
                System.err.println("Error registering user: " + ex.getMessage());
            }
        });

        backButton.setOnAction(e -> SceneManager.showLogin(stage));

        VBox root = new VBox(10,
                titleLabel,
                usernameField,
                passwordField,
                registerButton,
                backButton,
                message
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 300, 300));
        stage.setTitle("PharmCart Registration");
        stage.show();
    }
}