package model;

/*
 * Name: Chadwick Smith
 * Course: CST 338
 * Project: PharmCart - Pharmacy E-Commerce Application
 * Description: Product model class used for pharmacy inventory records.
 */

public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private int quantityInStock;

    public Product() {
    }

    public Product(String name, String category, double price, int quantityInStock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public Product(int productId, String name, String category, double price, int quantityInStock) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return name + " | " + category + " | $" + price + " | Stock: " + quantityInStock;
    }


}