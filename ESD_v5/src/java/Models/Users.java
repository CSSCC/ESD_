package Models;

import Models.Jdbc;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users {
    
    ArrayList<String> memId;
    
    int memberSize;

    public Users() throws SQLException {
        
        //Checks values of variables after querying database
        memId = Jdbc.runQuery("SELECT * FROM users", "mem_id");

    }

    // getters and setters for the member class
    public String getMemId(int index) throws SQLException {

        memId = Jdbc.runQuery("SELECT * FROM users", "mem_id");
        String individual_memId = memId.get(index);

        return individual_memId;
    }
    
    
}