/*
 * PharmCart JavaFX Application
 * Course: CST 338
 *
 * Author: Elizabeth Leon
 *
 * Description:
 * Stores cart items during the current application session.
 *
 */

package ui;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static final List<Product> cartItems = new ArrayList<>();

    public static void addProduct(Product product) {
        cartItems.add(product);
    }

    public static void removeProduct(Product product) {
        cartItems.remove(product);
    }

    public static List<Product> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public static void clearCart() {
        cartItems.clear();
    }

    public static double getTotal() {
        double total = 0.0;
        for (Product product : cartItems) {
            total += product.getPrice();
        }
        return total;
    }

    public static boolean isEmpty() {
        return cartItems.isEmpty();
    }
}