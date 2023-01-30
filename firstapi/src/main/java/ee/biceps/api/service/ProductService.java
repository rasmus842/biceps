package ee.biceps.api.service;

import ee.biceps.api.db.model.Product;

import java.util.List;

public interface ProductService {
    public Product getProductByName(String name);
    public List<Product> getProductsByCategory(String category);
}
