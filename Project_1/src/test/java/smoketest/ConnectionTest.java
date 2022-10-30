package smoketest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utility.ConnectionFactory;

import java.sql.Connection;

import java.sql.SQLException;

public class ConnectionTest {
    @Test
    void connection_available()throws SQLException{
        Connection connection = ConnectionFactory.getConnection();
        System.out.println(connection);
        Assertions.assertNotNull(connection);
    }


}
