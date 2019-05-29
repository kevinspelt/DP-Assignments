package P6;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteBaseDao {
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src/P6/db/P6.db");
            System.out.println("Connection has been made");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
