/*
 * PharmCart JavaFX Application
 * Course: CST 338
 *
 * Author: Elizabeth Leon
 *
 * Description:
 * Displays cart items and provides checkout and navigation options.
 *
 */

package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Product;

public class CartView {

    public void start(Stage stage) {
        Label titleLabel = new Label("Your Cart");
        ListView<Product> cartListView = new ListView<>();
        Label totalLabel = new Label();
        Label messageLabel = new Label();

        Button checkoutButton = new Button("Checkout");
        Button backToProductsButton = new Button("Back to Products");
        Button backToLoginButton = new Button("Back to Login");

        refreshCart(cartListView, totalLabel);

        checkoutButton.setOnAction(e -> {
            if (CartManager.isEmpty()) {
                messageLabel.setText("Cart is empty");
                return;
            }

            messageLabel.setText("Checkout coming next");
        });

        backToProductsButton.setOnAction(e -> SceneManager.showProducts(stage));
        backToLoginButton.setOnAction(e -> SceneManager.showLogin(stage));

        VBox root = new VBox(10,
                titleLabel,
                cartListView,
                totalLabel,
                checkoutButton,
                backToProductsButton,
                backToLoginButton,
                messageLabel
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("PharmCart Cart");
        stage.show();
    }

    private void refreshCart(ListView<Product> cartListView, Label totalLabel) {
        cartListView.getItems().setAll(CartManager.getCartItems());
        totalLabel.setText("Total: $" + String.format("%.2f", CartManager.getTotal()));
    }
}