package ui;

import dao.ProductDao;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Product;

public class AdminInventoryView extends Application {

    private final ProductDao productDao = new ProductDao();
    private final ListView<Product> productListView = new ListView<>();

    private final TextField nameField = new TextField();
    private final TextField categoryField = new TextField();
    private final TextField priceField = new TextField();
    private final TextField stockField = new TextField();

    private final Label messageLabel = new Label();

    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("Admin Inventory");

        nameField.setPromptText("Product Name");
        categoryField.setPromptText("Category");
        priceField.setPromptText("Price");
        stockField.setPromptText("Stock Quantity");

        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");

        addButton.setOnAction(e -> addProduct());
        updateButton.setOnAction(e -> updateProduct());
        deleteButton.setOnAction(e -> deleteProduct());

        productListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, selected) -> {
            if (selected != null) {
                nameField.setText(selected.getName());
                categoryField.setText(selected.getCategory());
                priceField.setText(String.valueOf(selected.getPrice()));
                stockField.setText(String.valueOf(selected.getQuantityInStock()));
            }
        });

        try {
            loadProducts();
        } catch (Exception e) {
            messageLabel.setText("Could not load products");
            e.printStackTrace();
        }

        VBox root = new VBox(10,
                titleLabel,
                productListView,
                nameField,
                categoryField,
                priceField,
                stockField,
                addButton,
                updateButton,
                deleteButton,
                messageLabel
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 400, 550));
        stage.setTitle("PharmCart Admin Inventory");
        stage.show();
    }

    private void loadProducts() {
        productListView.getItems().setAll(productDao.getAllProducts());
    }

    private void clearFields() {
        nameField.clear();
        categoryField.clear();
        priceField.clear();
        stockField.clear();
    }

    private void addProduct() {
        try {
            String name = nameField.getText().trim();
            String category = categoryField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int stock = Integer.parseInt(stockField.getText().trim());

            if (name.isEmpty() || category.isEmpty()) {
                messageLabel.setText("Name and category cannot be empty");
                return;
            }

            Product product = new Product(name, category, price, stock);
            productDao.insertProduct(product);

            messageLabel.setText("Product added successfully");
            clearFields();
            loadProducts();

        } catch (Exception e) {
            messageLabel.setText("Invalid input. Check price and stock.");
            e.printStackTrace();
        }
    }

    private void updateProduct() {
        try {
            Product selected = productListView.getSelectionModel().getSelectedItem();

            if (selected == null) {
                messageLabel.setText("Select a product first");
                return;
            }

            selected.setName(nameField.getText().trim());
            selected.setCategory(categoryField.getText().trim());
            selected.setPrice(Double.parseDouble(priceField.getText().trim()));
            selected.setQuantityInStock(Integer.parseInt(stockField.getText().trim()));

            productDao.updateProduct(selected);

            messageLabel.setText("Product updated successfully");
            clearFields();
            loadProducts();

        } catch (Exception e) {
            messageLabel.setText("Invalid input. Check price and stock.");
            e.printStackTrace();
        }
    }

    private void deleteProduct() {
        try {
            Product selected = productListView.getSelectionModel().getSelectedItem();

            if (selected == null) {
                messageLabel.setText("Select a product first");
                return;
            }

            productDao.deleteProduct(selected.getProductId());
            messageLabel.setText("Product deleted successfully");
            clearFields();
            loadProducts();

        } catch (Exception e) {
            messageLabel.setText("Delete failed");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}