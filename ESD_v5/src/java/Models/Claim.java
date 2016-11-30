package Models;

import Models.Jdbc;
import java.sql.SQLException;
import java.util.ArrayList;

public class Claim {
    
    ArrayList<String> id;
    ArrayList<String> memId;
    ArrayList<String> date;
    ArrayList<String> rationale;
    ArrayList<String> status;
    ArrayList<String> amount;
    
    int claimSize;

    public Claim() throws SQLException {
        
        //Checks values of variables after querying database
        id = Jdbc.runQuery("SELECT * FROM claims", "id");
        
        memId = Jdbc.runQuery("SELECT * FROM claims", "mem_id");
        
        date = Jdbc.runQuery("SELECT * FROM claims", "date");

        rationale = Jdbc.runQuery("SELECT * FROM claims", "rationale");

        status = Jdbc.runQuery("SELECT * FROM claims", "status");
        
        amount = Jdbc.runQuery("SELECT * FROM claims", "amount");      
        
        claimSize = id.size();
    }

    // getters and setters for the claim class
    public String getId(int index) throws SQLException {

        id = Jdbc.runQuery("SELECT * FROM claims", "id");
        String individual_id = id.get(index);

        return individual_id;
    }
    
    public String getMemId(int index) throws SQLException {

        memId = Jdbc.runQuery("SELECT * FROM claims", " mem_id");
        String individual_memId =  memId.get(index);

        return individual_memId;
    }

    public String getDate(int index) throws SQLException {

        date = Jdbc.runQuery("SELECT * FROM claims", "date");
        String individual_date = date.get(index);

        return individual_date;
    }

    public String getRationale(int index) throws SQLException {

        rationale = Jdbc.runQuery("SELECT * FROM claims", "rationale");
        String individual_rationale = rationale.get(index);

        return individual_rationale;
    }
    
    public String getStatus(int index) throws SQLException {

        status = Jdbc.runQuery("SELECT * FROM claims", "status");
        String individual_status = status.get(index);

        return individual_status;
    }
    
    public String getAmount(int index) throws SQLException {

        amount = Jdbc.runQuery("SELECT * FROM claims", "amount");
        String individual_amount = amount.get(index);

        return individual_amount;
    }
    
    
    public int getClaimsSize() throws SQLException {
        id = Jdbc.runQuery("SELECT * FROM claims", "id");
        return this.id.size();
    }

}