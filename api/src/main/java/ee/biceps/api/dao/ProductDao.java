package ee.biceps.api.dao;

import ee.biceps.api.model.Product;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterBeanMapper(Product.class)
public interface ProductDao {
    @SqlQuery("SELECT * FROM product")
    List<Product> selectProducts();

    @SqlQuery("SELECT * FROM product"
            + " WHERE id = :id")
    Product selectProductById(@Bind("id") Long id);

    @SqlQuery("SELECT * FROM product"
            + " WHERE category = :category")
    Product selectProductByCategory(@Bind("category") String category);

    @SqlQuery("SELECT * FROM product"
            + " WHERE name = :name")
    Product selectProductByName(@Bind("name") String name);

}
