package DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
    public static Connection connectToDB() {
        Connection connection = null;
        String url = "jdbc:sqlserver://UMINDU-LAPTOP\\SQLEXPRESS;databaseName=ServiceCenter;integratedSecurity=true;encrypt=false;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver not found");
        } catch (SQLException e) {
            System.err.println("Connection to SQL Server failed");
        }
        return connection;
    }
}
