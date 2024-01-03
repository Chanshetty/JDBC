package JdbcSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConfigration {
    private String url = "jdbc:mysql://localhost:3306/selflearn";
    private String userName = "root";
    private String passWord = "Chetu@2426";

    public Connection getConnection() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, userName, passWord);
            boolean isConnected = connection.isValid(5);
            System.out.println("Connection status: " + isConnected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return connection;
    }
}
