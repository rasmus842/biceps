package ee.biceps.api.db.dao;

import ee.biceps.api.db.model.ShoppingCart;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterBeanMapper(ShoppingCart.class)
public interface ShoppingCartDao extends DatabaseModelAccessor<ShoppingCart, Long> {
    String TABLE_NAME = "shopping_cart";
    String FIELD_NAMES_WITH_ID = "id, account_id, product_id, amount, total_price, status";
    String FIELD_NAMES = "account_id, product_id, amount, total_price, status";

    @SqlQuery("SELECT " + FIELD_NAMES_WITH_ID
            + " FROM " + TABLE_NAME
            + " WHERE id = :id")
    ShoppingCart findById(@Bind("id") Long id);

    @SqlQuery("SELECT " + FIELD_NAMES_WITH_ID
            + " FROM " + TABLE_NAME)
    List<ShoppingCart> findAll();

    @SqlQuery("SELECT " + FIELD_NAMES_WITH_ID
            + " FROM " + TABLE_NAME
            + " WHERE account_id = :accountId")
    List<ShoppingCart> findByAccountId(@Bind("accountId") Long accountId);

    @SqlUpdate("INSERT INTO " + TABLE_NAME
            + " (" + FIELD_NAMES + ")"
            + " VALUES (:accountId, :productId, :amount, :totalPrice, :status)")
    boolean insert(@BindBean ShoppingCart shoppingCart);

    @SqlBatch("INSERT INTO " + TABLE_NAME
            + " (" + FIELD_NAMES + ")"
            + " VALUES (:accountId, :productId, :amount, :totalPrice, :status)")
    void batchInsert(@BindBean List<ShoppingCart> shoppingCarts);

    @SqlUpdate("UPDATE " + TABLE_NAME
            + " SET account_id=:accountId, product_id=:productId, amount=:amount, total_price=:totalPrice, status=:status"
            + " WHERE id=:id")
    boolean updateById(@Bind("id") Long id, @BindBean ShoppingCart shoppingCart);

    @SqlUpdate("DELETE FROM " + TABLE_NAME
            + " WHERE id=:id")
    boolean deleteById(@Bind("id") Long id);
}
