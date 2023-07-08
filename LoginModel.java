import java.sql.*;
public class LoginModel {
       private static final String url = "jdbc:mysql://localhost:3306/acconts";
        private static final String username="root";
        private static final String password= "bhargav@2004";
        private static  Connection connection;
public static Connection Connector() {
    try {
        connection = DriverManager.getConnection(url,username,password);
        return connection;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}
public boolean isDbConnected() {
    try {
        return (!connection.isClosed());
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean isLogin(String user, String pass) throws Exception{
    
    Statement statement = connection.createStatement();
    String query = "SELECT * FROM userid WHERE username ='" + user + "'AND password ='"+pass+";";
    ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
}

}
