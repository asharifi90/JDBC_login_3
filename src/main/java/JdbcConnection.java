import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private final Connection connection =
            DriverManager.getConnection("jdbc:postgresql://172.17.0.2:5432/postgres", "postgres", "postgres");

    public JdbcConnection() throws SQLException {
    }

    public Connection getConnection() {
        return connection;
    }
}
