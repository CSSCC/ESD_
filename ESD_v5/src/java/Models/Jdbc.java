package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RickyL
 */
public class Jdbc {

    private String sqlStatement = null;
    private static Connection con = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

 
    
    
    

  public Jdbc()
  {
    
  }

    
    
    
    
    
    public void setSqlStatement(String sqlStatement) {
        this.sqlStatement = sqlStatement;
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
    public static void closeConnection(Connection c){
        try{
             c.close();
        }
        catch(SQLException ex){
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    //database run query
    public static ArrayList runQuery(String query, String column) throws SQLException{
      ArrayList al = new ArrayList();
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
                al.add(rs.getString(column));
        }
        return al;   
        
    }
    
     public void executeSQLUpdate(String sqlStatement) {

        //Set SQL statement
        if (this.sqlStatement == null) {
            setSqlStatement(sqlStatement);
        }
        System.out.println("Executing SQL Statement:");
        System.out.println(sqlStatement + "\n");
        //Execute SQL query
        try {
            //Create statment
            statement = con.createStatement();
            //Execute update
            statement.executeUpdate(sqlStatement);
            System.out.println("SQL Update Successful.\n");

        } catch (SQLException e) {
            System.out.println("SQL Statement Not Executed...\n" + e.toString() + "\n");
        }
    }
     
    //database run update
    public static void runUpdate(String update) throws SQLException{
        Statement st = con.createStatement();
        st.executeUpdate(update);     
        
    }
    
    
}
