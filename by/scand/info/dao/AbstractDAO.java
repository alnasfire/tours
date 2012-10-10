package by.scand.info.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: nasgor
 * Date: 10/10/12
 * Time: 4:04 PM
 */
public class AbstractDAO {
    public Connection getConnection() throws DAOException {
        try {
            return Connector.getConnection("jdbc:mysql://192.168.1.217:3306/geoiptest?characterEncoding=utf8", "root", "tiranus");
        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }
    }

    public void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
