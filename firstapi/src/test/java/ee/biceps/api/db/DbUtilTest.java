package ee.biceps.api.db;

import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DbUtilTest {

    @Test
    void getPropertyTest() {
        Properties props = DbUtil.getProps();
        assertNotNull(props, "Property file successfully loaded");
        String driver = props.getProperty("db.driver");
        assertEquals("org.postgresql.Driver", driver, "Db driver should match");
    }

    @Test
    void getConnectionTest() {
        Connection dbConnection = DbUtil.getConnection();
        assertNotNull(dbConnection, "connection should be successful.");

    }

    @Test
    void getJdbiTest() {
        Jdbi jdbi = DbUtil.getJdbi();
        assertNotNull(jdbi, "Jdbi instance creation should be successful");
    }

}
