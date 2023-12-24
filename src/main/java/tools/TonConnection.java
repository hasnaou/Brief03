package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TonConnection {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/brief03";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url,username,password);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e1) {
            e1.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
