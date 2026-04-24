/*
 * PharmCart JavaFX Application
 * Course: CST 338
 *
 * Author: Elizabeth Leon
 *
 * Description:
 * Displays products, allows users to add products to cart, and navigate to cart or login.
 *
 */

package ui;

import dao.ProductDao;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Product;

import java.util.List;

public class ProductView {

    private final ProductDao productDao = new ProductDao();
    private final ListView<Product> productListView = new ListView<>();

    public void start(Stage stage) {
        Label titleLabel = new Label("Available Pharmacy Products");
        Label subtitle = new Label("Select products to add to your cart");
        Button refreshButton = new Button("Refresh");
        Button addToCartButton = new Button("Add Selected to Cart");
        Button viewCartButton = new Button("View Cart");
        Button backToLoginButton = new Button("Back to Login");
        Label messageLabel = new Label();

        refreshButton.setOnAction(e -> {
            loadProducts(messageLabel);
            messageLabel.setText("Product list refreshed");
        });

        addToCartButton.setOnAction(e -> {
            Product selected = productListView.getSelectionModel().getSelectedItem();

            if (selected == null) {
                messageLabel.setText("Please select a product first");
            } else {
                CartManager.addProduct(selected);
                messageLabel.setText(selected.getName() + " added to cart");
            }
        });

        viewCartButton.setOnAction(e -> SceneManager.showCart(stage));
        backToLoginButton.setOnAction(e -> {
            CartManager.clearCart();
            SceneManager.showLogin(stage);
        });

        loadProducts(messageLabel);

        VBox root = new VBox(10,
                titleLabel,
                subtitle,
                productListView,
                refreshButton,
                addToCartButton,
                viewCartButton,
                backToLoginButton,
                messageLabel
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 450, 450));
        stage.setTitle("PharmCart Products");
        stage.show();
    }

    private void loadProducts(Label messageLabel) {
        try {
            List<Product> products = productDao.getAllProducts();
            productListView.getItems().setAll(products);

            if (products.isEmpty()) {
                messageLabel.setText("No products found");
            }
        } catch (Exception e) {
            messageLabel.setText("Failed to load products");
            System.err.println("Error loading products: " + e.getMessage());
        }
    }
}