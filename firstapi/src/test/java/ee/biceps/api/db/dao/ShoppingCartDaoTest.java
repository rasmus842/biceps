package ee.biceps.api.db.dao;

import ee.biceps.api.db.model.ShoppingCart;
import ee.biceps.api.testUtils.DbTestUtils;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartDaoTest {
    private static final String INIT_SQL = "CREATE TABLE shopping_cart (" +
            " id BIGSERIAL PRIMARY KEY," +
            " account_id BIGINT NOT NULL," +
            " product_id BIGINT NOT NULL," +
            " amount INT NOT NULL," +
            " total_price NUMERIC(8,2)" +
            " status shopping_cart_status NOT NULL" +
            ")";
    private static final String TEARDOWN_SQL = "DROP TABLE shopping_cart";

    private static Jdbi jdbi;
    private static ShoppingCartDao shoppingCartDao;

    @BeforeAll
    static void setup() {
        jdbi = DbTestUtils.getJdbi();
        assertNotNull(jdbi);
        jdbi.useHandle(h -> h.execute(INIT_SQL));
    }

    @BeforeEach
    void beforeEach() {
        shoppingCartDao = jdbi.onDemand(ShoppingCartDao.class);
    }

    @AfterAll
    static void tearDown() {
        jdbi.useHandle(handle -> handle.execute(TEARDOWN_SQL));
    }

    @Test
    void testInsert() {
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .accountId(0L)
                .productId(0L)
                .amount(1)
                .totalPrice(BigDecimal.valueOf(21))
                .status("NEW")
                .build();
        boolean insertedId = shoppingCartDao.insert(shoppingCart);
        assertTrue(insertedId);
    }
}