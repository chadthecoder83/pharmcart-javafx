import dao.ProductDao;
import database.DatabaseInitializer;
import model.Product;

import java.util.List;

public class TestProductDao {
    public static void main(String[] args) {
        DatabaseInitializer.initializeDatabase();

        ProductDao productDao = new ProductDao();

        Product product = new Product("Tylenol", "Pain Relief", 8.99, 25);
        productDao.insertProduct(product);

        List<Product> products = productDao.getAllProducts();
        System.out.println("All products after insert:");
        for (Product p : products) {
            System.out.println(p);
        }

        if (!products.isEmpty()) {
            Product firstProduct = products.get(0);
            firstProduct.setPrice(9.99);
            firstProduct.setQuantityInStock(30);
            productDao.updateProduct(firstProduct);

            System.out.println("All products after update:");
            for (Product p : productDao.getAllProducts()) {
                System.out.println(p);
            }

            productDao.deleteProduct(firstProduct.getProductId());

            System.out.println("All products after delete:");
            for (Product p : productDao.getAllProducts()) {
                System.out.println(p);
            }
        }
    }
}