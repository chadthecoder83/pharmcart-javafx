/*
 * PharmCart JavaFX Application
 * Course: CST 338
 *
 * @author Elizabeth Leon
 * @since 4/20/26
 * Description:
 * Displays pharmacy products loaded from the database.
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

        Button refreshButton = new Button("Refresh");
        Label messageLabel = new Label();

        refreshButton.setOnAction(e -> {
            loadProducts(messageLabel);
            messageLabel.setText("Product list refreshed");
        });

        loadProducts(messageLabel);

        VBox root = new VBox(10, titleLabel, productListView, refreshButton, messageLabel);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 450, 400));
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