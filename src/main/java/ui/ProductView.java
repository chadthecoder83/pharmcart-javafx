package ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductView {

    public void start(Stage stage) {
        Label titleLabel = new Label("Available Products");

        ListView<String> productList = new ListView<>();
        productList.getItems().add("Tylenol - $8.99");
        productList.getItems().add("Advil - $7.99");
        productList.getItems().add("Benadryl - $6.49");

        VBox root = new VBox(10);
        root.getChildren().addAll(titleLabel, productList);

        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("PharmCart Products");
        stage.setScene(scene);
        stage.show();
    }
}