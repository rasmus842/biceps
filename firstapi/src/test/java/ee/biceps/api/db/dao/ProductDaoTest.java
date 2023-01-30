package ee.biceps.api.db.dao;

import ee.biceps.api.db.dao.impl.ProductDaoImpl;
import ee.biceps.api.db.model.Product;
import ee.biceps.api.testUtils.DbTestUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDaoTest {
    private static final String initSql = "CREATE TABLE product (" +
            " id BIGSERIAL PRIMARY KEY," +
            " name text NOT NULL," +
            " description text," +
            " category text," +
            " price int," +
            " unit text," +
            " available_amount int," +
            " image_path text" +
            ")";
    private static final String tearDownSql = "DROP TABLE product";
    private static ProductDao productDao;

    @BeforeAll
    static void init() {
            Connection conn = DbTestUtils.getConnection();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(initSql);
            System.out.println("Table successfully created");
        } catch (SQLException e) {
            System.out.println("Failed to initiate table");
            throw new RuntimeException(e);
        }
        productDao = new ProductDaoImpl(conn);
    }

    @AfterAll
    static void teardown() {
        Connection conn = DbTestUtils.getConnection();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(tearDownSql);
            System.out.println("Teardown successful");
        } catch (SQLException e) {
            System.out.println("Failed to teardown table");
            throw new RuntimeException(e);
        }
    }

    @Test
    void createProductTest() {
        Product product = Product.builder()
                .name("test")
                .description("test")
                .price(100)
                .unit("testUnits")
                .availableAmount(5)
                .build();
        productDao.createProduct(product);
        Product productFromDb = productDao.selectProductByName("test");
        assertEquals(product.getName(), productFromDb.getName(), "Products must be equal");
    }

    @Test
    void deleteProductByNameTest() {
        productDao.deleteProductByName("test");
        Product productFromDb = productDao.selectProductByName("test");
        assertNull(productFromDb.getName(), "Product should be null");
    }

    @Test
    void updateProductTest() {
        Product product = Product.builder()
                .name("testName")
                .description("testDescription")
                .price(100)
                .unit("testUnit")
                .availableAmount(5)
                .build();
        productDao.createProduct(product);
        Product otherProduct = Product.builder()
                .name("otherName")
                .build();
        productDao.updateProductByName("testName", otherProduct);
        Product updatedProduct = productDao.selectProductByName("otherName");
        assertEquals(otherProduct.getName(), updatedProduct.getName(), "product must be updated");
    }

    @Test
    void createProducts() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product newProduct = Product.builder()
                    .name("testProduct" + i)
                    .build();
            products.add(newProduct);
        }
        int addedProducts = productDao.createProducts(products);
        assertEquals(5, addedProducts, "5 products should be added");
    }

    @Test
    void selectProductsByCategory() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product newProduct = Product.builder()
                    .name("testProduct" + i)
                    .category("testCategory")
                    .build();
            products.add(newProduct);
        }
        productDao.createProducts(products);
        List<Product> noProducts = productDao.selectProductsByCategory("books");
        assertEquals(0, noProducts.size(), "No products in this cateogry");
        List<Product> fiveProducts = productDao.selectProductsByCategory("testCategory");
        assertEquals(5, fiveProducts.size(), "Five products in testCategory");

    }
}
