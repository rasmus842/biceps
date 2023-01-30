package ee.biceps.api.controller;

import ee.biceps.api.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        var product = new Product();
        product.setName("test");
        products.add(product);
        return products;
    }

}
