package P3.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
    private static String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String username = "KEVIN";
    private static String password = "geheim";

    private static Connection con;

    protected static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
