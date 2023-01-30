package ee.biceps.api.testUtils;

import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlScript;

@UseClasspathSqlLocator
public interface DbTestDao {
    @SqlScript("init_test_db")
    void initDb();

    @SqlScript("teardown_test_db")
    void teardownDb();
}
