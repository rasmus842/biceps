package ee.biceps.api.service;

import ee.biceps.api.dao.ProductDao;
import ee.biceps.api.model.Product;
import ee.biceps.generated.api.ProductsApiDelegate;
import ee.biceps.generated.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductApiDelegateImpl implements ProductsApiDelegate {
    // TODO - time to start thinking of how to bring database, service and api layers together
    private final ProductDao productDao;

    public ProductApiDelegateImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO) {
        var product = new ProductDTO();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(product);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProducts(Integer maxResults) {
        return ProductsApiDelegate.super.getProducts(maxResults);
    }

    @Override
    public ResponseEntity<Void> removeProduct(Integer productId) {
        return ProductsApiDelegate.super.removeProduct(productId);
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(Integer productId, ProductDTO productDTO) {
        return ProductsApiDelegate.super.updateProduct(productId, productDTO);
    }
}
