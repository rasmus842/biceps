package ee.biceps.api.service.implementation;

import ee.biceps.api.db.DbUtil;
import ee.biceps.api.db.dao.ProductDao;
import ee.biceps.api.db.model.Product;
import ee.biceps.api.service.ProductService;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl() {
        Jdbi jdbi = DbUtil.getJdbi();
        this.productDao = jdbi.onDemand(ProductDao.class);
    }

    public ProductServiceImpl(Jdbi jdbi) {
        this.productDao = jdbi.onDemand(ProductDao.class);
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return null;
    }
}
