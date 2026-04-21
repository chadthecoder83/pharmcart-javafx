package dao;

import database.DatabaseInitializer;
import model.Order;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderDaoTest {

    private OrderDao orderDao;
    private ProductDao productDao;

    @BeforeEach
    void setUp() {
        DatabaseInitializer.initializeDatabase();
        orderDao = new OrderDao();
        productDao = new ProductDao();
        productDao.insertProduct(new Product("Test Product", "Test", 5.99, 10));
    }

    @Test
    void testInsertOrder() {
        Product product = productDao.getAllProducts().get(0);

        Order order = new Order(
                1,
                product.getProductId(),
                2,
                11.98,
                "Placed",
                LocalDateTime.now().toString()
        );

        boolean result = orderDao.insertOrder(order);
        assertTrue(result);
    }
}