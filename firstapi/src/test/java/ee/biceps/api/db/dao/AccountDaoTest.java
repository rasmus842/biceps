package ee.biceps.api.db.dao;

import ee.biceps.api.db.dao.impl.AccountDaoImpl;
import ee.biceps.api.db.model.Account;
import ee.biceps.api.testUtils.DbTestUtils;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class AccountDaoTest {
    private static final String INIT_SQL = "CREATE TABLE account (" +
            " id BIGSERIAL PRIMARY KEY," +
            " username text NOT NULL," +
            " password_hash text NOT NULL," +
            " created_at timestamptz NOT NULL," +
            " status text NOT NULL" +
            ")";
    private static final String TEARDOWN_SQL = "DROP TABLE account";
    private static final Timestamp TEST_TIMESTAMP = Timestamp.valueOf("2022-11-10 20:55:37.999999");

    private static Jdbi jdbi;

    private AccountDao accountDao;

    @BeforeAll
    static void setup() {
        jdbi = DbTestUtils.getJdbi();
        assertNotNull(jdbi);
        jdbi.registerRowMapper(Account.class,
                (rs, ctx) -> Account.builder()
                        .id(rs.getLong("id"))
                        .username(rs.getString("username"))
                        .passwordHash(rs.getString("password_hash"))
                        .createdAt(rs.getTimestamp("created_at"))
                        .status(rs.getString("status"))
                        .build());
        jdbi.useHandle(h -> h.execute(INIT_SQL));
    }

    @BeforeEach
    void beforeEach() {
        accountDao = new AccountDaoImpl(jdbi);
    }

    @AfterAll
    static void tearDown() {
        jdbi.useHandle(handle -> handle.execute(TEARDOWN_SQL));
    }

    @Test
    void createAccountTest() {
        Account testAccount = Account.builder()
                .username("rasmus842")
                .passwordHash("1234")
                .createdAt(TEST_TIMESTAMP)
                .status("ACTIVE")
                .build();
        Long createdId = accountDao.createAccount(testAccount);
        assertNotNull(createdId, "Account should be successfully created with generated id");
        Account fetchedAccount = accountDao.selectAccountByUsername("rasmus842");

        testAccount.setId(createdId);
        assertEquals(testAccount, fetchedAccount, "Correct account is created and fetched");
    }

    @Test
    void deleteAccountTest() {
        Account testAccount = Account.builder()
                .username("randomUser")
                .passwordHash("1234")
                .createdAt(TEST_TIMESTAMP)
                .status("ACTIVE")
                .build();
        Long createdId = accountDao.createAccount(testAccount);
        assertNotNull(createdId, "Account should be successfully created with generated id");

        boolean isDeleted = accountDao.deleteAccountByUsername("randomUser");
        assertTrue(isDeleted);

        Account deletedAccount = accountDao.selectAccountByUsername("randomUser");
        assertNull(deletedAccount, "Account should be deleted");
    }

    @Test
    void updateAccountTest() {
        Account testAccount = Account.builder()
                .username("updateThisUser")
                .passwordHash("1234")
                .createdAt(TEST_TIMESTAMP)
                .status("ACTIVE")
                .build();
        Long createdId = accountDao.createAccount(testAccount);
        assertNotNull(createdId, "Account should be successfully created with generated id");

        boolean isUpdated = accountDao.updateAccountFieldByUsername(
                "updateThisUser",
                "status",
                "INACTIVE", String.class);
        assertTrue(isUpdated);

        Account fetchedAccount = accountDao.selectAccountByUsername("updateThisUser");
        assertEquals("INACTIVE", fetchedAccount.getStatus(), "Account should be updated");
    }
}
