/*
 * PharmCart JavaFX Application
 * Course: CST 338
 *
 * Author: Elizabeth Leon
 *
 * Description:
 * Displays cart items and provides checkout, remove-item, and navigation options.
 *
 */

package ui;

import dao.OrderDao;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Order;
import model.Product;

import java.time.LocalDateTime;
import java.util.List;

public class CartView {

    public void start(Stage stage) {
        Label titleLabel = new Label("Your Cart");
        ListView<Product> cartListView = new ListView<>();
        Label totalLabel = new Label();
        Label messageLabel = new Label();

        Button removeSelectedButton = new Button("Remove Selected Item");
        Button checkoutButton = new Button("Checkout");
        Button backToProductsButton = new Button("Back to Products");
        Button backToLoginButton = new Button("Back to Login");

        refreshCart(cartListView, totalLabel);

        removeSelectedButton.setOnAction(e -> {
            Product selected = cartListView.getSelectionModel().getSelectedItem();

            if (selected == null) {
                messageLabel.setText("Select an item to remove");
            } else {
                CartManager.removeProduct(selected);
                refreshCart(cartListView, totalLabel);
                messageLabel.setText(selected.getName() + " removed from cart");
            }
        });

        checkoutButton.setOnAction(e -> {
            if (CartManager.isEmpty()) {
                messageLabel.setText("Cart is empty");
                return;
            }

            try {
                OrderDao orderDao = new OrderDao();
                List<Product> items = CartManager.getCartItems();

                boolean allInserted = true;

                for (Product product : items) {
                    Order order = new Order(
                            1, // placeholder user_id for now
                            product.getProductId(),
                            1,
                            product.getPrice(),
                            "Placed",
                            LocalDateTime.now().toString()
                    );

                    boolean inserted = orderDao.insertOrder(order);
                    if (!inserted) {
                        allInserted = false;
                        break;
                    }
                }

                if (allInserted) {
                    CartManager.clearCart();
                    refreshCart(cartListView, totalLabel);
                    messageLabel.setText("Checkout complete");
                } else {
                    messageLabel.setText("Checkout failed");
                }

            } catch (Exception ex) {
                messageLabel.setText("Checkout failed");
                System.err.println("Checkout error: " + ex.getMessage());
            }
        });

        backToProductsButton.setOnAction(e -> SceneManager.showProducts(stage));

        backToLoginButton.setOnAction(e -> {
            CartManager.clearCart();
            SceneManager.showLogin(stage);
        });

        VBox root = new VBox(10,
                titleLabel,
                cartListView,
                totalLabel,
                removeSelectedButton,
                checkoutButton,
                backToProductsButton,
                backToLoginButton,
                messageLabel
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 400, 450));
        stage.setTitle("PharmCart Cart");
        stage.show();
    }

    private void refreshCart(ListView<Product> cartListView, Label totalLabel) {
        cartListView.getItems().setAll(CartManager.getCartItems());
        totalLabel.setText("Total: $" + String.format("%.2f", CartManager.getTotal()));
    }
}