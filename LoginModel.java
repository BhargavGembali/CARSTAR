import java.sql.*;

public class LoginModel {

    private static final String url = "jdbc:mysql://localhost:3306/accounts";
    private static final String username = "root";
    private static final String password = "bhargav@2004";
    private static Connection connection;

    public static Connection Connector() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isDbConnected() {
        try {
            return (connection != null && !connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLogin(String user, String pass) {
        if (connection == null) {
            return false; // Return false if the connection is not established
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM userid WHERE username = ? AND password = ?");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next(); // Return true if there are results (user exists with provided credentials)
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
