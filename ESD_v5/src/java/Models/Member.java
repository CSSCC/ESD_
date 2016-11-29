package Models;

import Models.Jdbc;
import java.sql.SQLException;
import java.util.ArrayList;

public class Member {
    
    ArrayList<String> id;
    ArrayList<String> name;
    ArrayList<String> address;
    ArrayList<String> dob;
    ArrayList<String> dor;
    ArrayList<String> status;
    ArrayList<String> balance ;
    int memberSize;

    public Member() throws SQLException {
        id = Jdbc.runQuery("SELECT * FROM members", "id");
        
        name = Jdbc.runQuery("SELECT * FROM members", "name");
        
        address = Jdbc.runQuery("SELECT * FROM members", "address");

        dob = Jdbc.runQuery("SELECT * FROM members", "dob");

        dor = Jdbc.runQuery("SELECT * FROM members", "dor");
        
        status = Jdbc.runQuery("SELECT * FROM members", "status");
        
        balance = Jdbc.runQuery("SELECT * FROM members", "balance");
       
        
        memberSize = id.size();
    }

    
    public String getId(int index) throws SQLException {

        id = Jdbc.runQuery("SELECT * FROM members", "id");
        String individual_id = id.get(index);

        return individual_id;
    }
    
    public String getName(int index) throws SQLException {

        name = Jdbc.runQuery("SELECT * FROM members", "name");
        String individual_name = name.get(index);

        return individual_name;
    }

    public String getAddress(int index) throws SQLException {

        address = Jdbc.runQuery("SELECT * FROM members", "address");
        String individual_address = address.get(index);

        return individual_address;
    }

    public String getDob(int index) throws SQLException {

        dob = Jdbc.runQuery("SELECT * FROM members", "dob");
        String individual_dob = dob.get(index);

        return individual_dob;
    }
    
    public String getDor(int index) throws SQLException {

        dor = Jdbc.runQuery("SELECT * FROM members", "dor");
        String individual_dor = dor.get(index);

        return individual_dor;
    }
    
    public String getStatus(int index) throws SQLException {

        status = Jdbc.runQuery("SELECT * FROM members", "status");
        String individual_status = status.get(index);

        return individual_status;
    }
    
    public String getBalance(int index) throws SQLException {

        balance = Jdbc.runQuery("SELECT * FROM members", "balance");
        String individual_balance = balance.get(index);

        return individual_balance;
    }
    
    public int getMembersSize() throws SQLException {
        id = Jdbc.runQuery("SELECT * FROM members", "id");
        return this.id.size();
    }

}