package Models;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author CSSCC
 */
public class Login {
   
    ArrayList<String> Username;
    ArrayList<String> Password;

    public Login() throws SQLException { 
        
        //Checks values of variables after querying database
        Username = Jdbc.runQuery("SELECT * FROM users", "id");
        
        Password = Jdbc.runQuery("SELECT * FROM users", "password");
  
    }
    //get username
    public ArrayList<String> getUsername() {
        return Username;
    }
    //get password
    public ArrayList<String> getPassword() {
        return Password;
    }
    
}
