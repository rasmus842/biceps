package ee.biceps.api.db.dao;

import ee.biceps.api.testUtils.DbTestDao;
import ee.biceps.api.testUtils.DbTestUtils;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InitDbTestDao {

    private static DbTestDao dbTestDao;

    @BeforeAll
    static void setup() throws Exception {
        Jdbi jdbi = DbTestUtils.getJdbi();
        dbTestDao = jdbi.onDemand(DbTestDao.class);
    }

    @Test
    void testInitDb() {
        dbTestDao.initDb();
    }
}
