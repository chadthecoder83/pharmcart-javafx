package dao;

import database.DatabaseInitializer;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDaoTest {

    private ProductDao productDao;

    @BeforeEach
    void setUp() {
        DatabaseInitializer.initializeDatabase();
        productDao = new ProductDao();
    }

    @Test
    void testInsertProduct() {
        Product product = new Product("Advil", "Pain Relief", 7.99, 15);
        productDao.insertProduct(product);

        List<Product> products = productDao.getAllProducts();

        boolean found = products.stream()
                .anyMatch(p -> p.getName().equals("Advil") && p.getCategory().equals("Pain Relief"));

        assertTrue(found, "Product should be inserted into database");
    }

    @Test
    void testGetAllProductsNotEmpty() {
        Product product = new Product("Benadryl", "Allergy", 6.49, 20);
        productDao.insertProduct(product);

        List<Product> products = productDao.getAllProducts();

        assertFalse(products.isEmpty(), "Product list should not be empty after insert");
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product("Tylenol", "Pain Relief", 8.99, 10);
        productDao.insertProduct(product);

        List<Product> products = productDao.getAllProducts();
        Product insertedProduct = products.get(products.size() - 1);

        insertedProduct.setPrice(10.99);
        insertedProduct.setQuantityInStock(30);
        productDao.updateProduct(insertedProduct);

        Product updatedProduct = productDao.getProductById(insertedProduct.getProductId());

        assertNotNull(updatedProduct, "Updated product should still exist");
        assertEquals(10.99, updatedProduct.getPrice(), 0.001, "Product price should be updated");
        assertEquals(30, updatedProduct.getQuantityInStock(), "Product stock should be updated");
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product("DeleteMe", "Test", 4.99, 5);
        productDao.insertProduct(product);

        List<Product> products = productDao.getAllProducts();
        Product insertedProduct = products.get(products.size() - 1);

        productDao.deleteProduct(insertedProduct.getProductId());

        Product deletedProduct = productDao.getProductById(insertedProduct.getProductId());

        assertNull(deletedProduct, "Product should be deleted from database");
    }
}