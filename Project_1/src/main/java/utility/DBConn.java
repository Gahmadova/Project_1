package utility;

import org.eclipse.jetty.client.api.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    public static Connection connection;

    public static Connection getConnection() {
        try {
            // create connection object, make connection with postgres db, return connection object
            connection = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=1005");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
