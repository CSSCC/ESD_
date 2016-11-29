package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PickyRickyL
 */
public class Jdbc {

    private static Connection con = null;

    static void runQuery(String select__into_journey_FROM_customers) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //create connection to database
    public Connection makeConnection(String url) {
        if (con != null) {
            return con;
        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con = DriverManager.getConnection(url, "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        return con;
    }

    //close connection
    public static void closeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //database run query
    public static ArrayList runQuery(String query, String column) throws SQLException {
        ArrayList al = new ArrayList();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            al.add(rs.getString(column));
        }
        return al;

    }

    //database run update
    public static void runUpdate(String update) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate(update);

    }

}
