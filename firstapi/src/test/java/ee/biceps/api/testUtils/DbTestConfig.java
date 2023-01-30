package ee.biceps.api.testUtils;

import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DbTestConfig implements BeforeAllCallback, AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        Jdbi jdbi = DbTestUtils.getJdbi();
        DbTestDao dbTestDao = jdbi.onDemand(DbTestDao.class);
        dbTestDao.initDb();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        Jdbi jdbi = DbTestUtils.getJdbi();
        DbTestDao dbTestDao = jdbi.onDemand(DbTestDao.class);
        dbTestDao.teardownDb();
    }

}
