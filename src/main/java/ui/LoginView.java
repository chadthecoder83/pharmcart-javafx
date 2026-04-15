package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * PharmCart JavaFX Application
 * Course: CST 338
 * @author Elizabeth Leon
 * @since 4-14-26
 * Description: Handles the login user interface and basic validation. Navigates to the product screen upon successful login.
 */
public class LoginView {

    public void start(Stage stage) {
        Label titleLabel = new Label("PharmCart Login");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");

        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
                messageLabel.setText("Fields cannot be empty");
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

        stage.setScene(new Scene(root, 300, 250));
        stage.setTitle("Login");
        stage.show();
    }
}