package ee.biceps.api.db.dao;

import ee.biceps.api.db.model.Product;

import java.util.List;

public interface ProductDao {

    String COLUMN_NAMES_NO_ID = "name, description, price, unit, available_amount, category, image_path";

    Product selectProductById(Long id);

    Product selectProductByName(String name);

    List<Product> selectProducts();

    List<Product> selectProductsByCategory(String category);

    Long createProduct(Product product);

    int createProducts(List<Product> product);

    boolean updateProductById(Long id, Product product);

    boolean updateProductByName(String name, Product product);

    boolean deleteProductById(Long id);

    boolean deleteProductByName(String name);
}
