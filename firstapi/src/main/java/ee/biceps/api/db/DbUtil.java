package ee.biceps.api.db;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static Connection connection = null;
    private static Properties props = null;

    private static Jdbi jdbi = null;

    public static Properties getProps() {
        if (props != null) {
            return props;

        } else {
            Properties props = new Properties();
            InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("api.properties");
            try {
                props.load(inputStream);
                return props;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties props = getProps();
                String driver = props.getProperty("db.driver");
                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

    public static Jdbi getJdbi() {
        Properties props = getProps();
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        Jdbi jdbi = Jdbi.create(url, user, password);
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }
}
