package Models;

import Models.Jdbc;
import java.sql.SQLException;
import java.util.ArrayList;

public class Payment {
    
    ArrayList<String> id;
    ArrayList<String> mem_id;
    ArrayList<String> date;
    ArrayList<String> type_of_payment;
    ArrayList<String> amount;
    
    int paymentSize;

    public Payment() throws SQLException {
        
        //Checks values of variables after querying database
        id = Jdbc.runQuery("SELECT * FROM payments", "id");
        
        mem_id = Jdbc.runQuery("SELECT * FROM payments", "mem_id");
        
        type_of_payment = Jdbc.runQuery("SELECT * FROM payments", "type_of_payment");

        amount = Jdbc.runQuery("SELECT * FROM payments", "amount");

        date = Jdbc.runQuery("SELECT * FROM payments", "date");
        
       
        paymentSize = id.size();
    }

    // getters and setters for the claim class
    public String getId(int index) throws SQLException {

        id = Jdbc.runQuery("SELECT * FROM payments", "id");
        String individual_id = id.get(index);

        return individual_id;
    }
    
    public String getMemId(int index) throws SQLException {

        mem_id = Jdbc.runQuery("SELECT * FROM payments", " mem_id");
        String individual_mem_id =  mem_id.get(index);

        return individual_mem_id;
    }

    public String getDate(int index) throws SQLException {

        date = Jdbc.runQuery("SELECT * FROM payments", "date");
        String individual_date = date.get(index);

        return individual_date;
    }

    public String getTypeOfPayment(int index) throws SQLException {

        type_of_payment = Jdbc.runQuery("SELECT * FROM payments", "type_of_payment");
        String individual_type_of_payment = type_of_payment.get(index);

        return individual_type_of_payment;
    }
    

    
    public String getAmount(int index) throws SQLException {

        amount = Jdbc.runQuery("SELECT * FROM payments", "amount");
        String individual_amount = amount.get(index);

        return individual_amount;
    }
    
    
    public int getPaymentSize() throws SQLException {
        id = Jdbc.runQuery("SELECT * FROM payments", "id");
        return this.id.size();
    }

}