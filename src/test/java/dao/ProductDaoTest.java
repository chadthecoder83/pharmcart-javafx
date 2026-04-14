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
        // Initialize database and DAO before each test
        DatabaseInitializer.initializeDatabase();
        productDao = new ProductDao();
    }

    @Test
    void testInsertProduct() {
        Product product = new Product("Advil", "Pain Relief", 7.99, 15);
        productDao.insertProduct(product);

        List<Product> products = productDao.getAllProducts();

        boolean found = products.stream()
                .anyMatch(p -> p.getName().equals("Advil"));

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
    void testDeleteProduct() {
        Product product = new Product("Tylenol", "Pain Relief", 8.99, 10);
        productDao.insertProduct(product);

        List<Product> products = productDao.getAllProducts();
        int id = products.get(0).getProductId();

        productDao.deleteProduct(id);

        List<Product> updatedProducts = productDao.getAllProducts();

        boolean exists = updatedProducts.stream()
                .anyMatch(p -> p.getProductId() == id);

        assertFalse(exists, "Product should be deleted from database");
    }
}