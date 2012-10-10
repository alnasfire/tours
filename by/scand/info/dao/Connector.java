package by.scand.info.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * User: nasgor
 * Date: 10/10/12
 * Time: 4:18 PM
 */
public class Connector {
    protected static Connection con = null;


    public static Connection getConnection(String url, String user, String password) throws SQLException, ClassNotFoundException {
        if (con == null) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        }
        return con;
    }

    public static void disconnect() throws SQLException {
        if (con != null) {
            con.close();
            con = null;
        }
    }
}
