package conections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
    public Connection connectionDb() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/bancoestoque";
        String user = "root";
        String password = "";

        return DriverManager.getConnection(url, user, password);

    }
}
