package ee.biceps.api.dao;

import ee.biceps.api.model.Product;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterBeanMapper(Product.class)
public interface ProductDao {
    String COLUMN_NAMES_NO_ID = "name, description, price, unit, available_amount, category, image_path";
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

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO product (" + COLUMN_NAMES_NO_ID + ")"
            + " VALUES (:name, :description, :price, :unit, :availableAmount, :category, :imagePath)")
    Long addProduct(@BindBean Product product);

}
