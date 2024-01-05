import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    private final JdbcConnection jdbcConnection = new JdbcConnection();

    public UserRepository() throws SQLException {
    }

    public int registerUser(User user) throws SQLException {
        Connection connection = jdbcConnection.getConnection();

        String addUser = "INSERT INTO users(first_name, last_name, username, password) VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());

        int result = preparedStatement.executeUpdate();
        return result;
    }
}
