package by.scand.info.dao;

import by.scand.info.model.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * User: nasgor
 * Date: 10/10/12
 * Time: 4:04 PM
 */
public class TourDAO extends AbstractDAO{
    public void insertTour(Tour tour) throws DAOException {
        PreparedStatement st = null;
        Connection con = getConnection();
        try {
            st = con.prepareStatement("INSERT <NAME TABLE> SET COUNTRY = ? "
                    + "WHERE ID_CITY = ? AND ID_IP = ?");
            st.setString(1, tour.getCountry());

            st.executeUpdate();
        } catch (Exception ex) {

        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception ex) {

            }
        }
    }
}