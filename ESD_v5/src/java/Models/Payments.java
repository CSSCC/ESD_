package Models;

import Models.Jdbc;
import java.sql.SQLException;
import java.util.ArrayList;

public class Payments {

    ArrayList<String> id;
    ArrayList<String> memId;                //mem_id
    ArrayList<String> typeOfPayment;        //type_of_payment
    ArrayList<String> amount;
    ArrayList<String> date;

    public Payments() throws SQLException {
        id = Jdbc.runQuery("SELECT * FROM payments", "id");

        memId = Jdbc.runQuery("SELECT * FROM payments", "mem_id");

        typeOfPayment = Jdbc.runQuery("SELECT * FROM payments", "type_of_payment");

        amount = Jdbc.runQuery("SELECT * FROM payments", "amount");

        date = Jdbc.runQuery("SELECT * FROM payments", "date");

    }

    public String getId(int index) throws SQLException {

        id = Jdbc.runQuery("SELECT * FROM payments", "id");
        String individual_id = id.get(index);

        return individual_id;
    }

    public String getMemId(int index) throws SQLException {

        memId = Jdbc.runQuery("SELECT * FROM payments", "mem_id");
        String individual_memId = memId.get(index);

        return individual_memId;
    }

    public String typeOfPayment(int index) throws SQLException {

        typeOfPayment = Jdbc.runQuery("SELECT * FROM payments", "typeOfPayment");
        String individual_typeOfPayment = typeOfPayment.get(index);

        return individual_typeOfPayment;
    }

    public String amount(int index) throws SQLException {

        amount = Jdbc.runQuery("SELECT * FROM payments", "amount");
        String individual_amount = amount.get(index);

        return individual_amount;
    }

    public String date(int index) throws SQLException {

        date = Jdbc.runQuery("SELECT * FROM payments", "date");
        String individual_date = date.get(index);

        return individual_date;
    }

//    public int getMembersSize() throws SQLException {
//        id = Jdbc.runQuery("SELECT * FROM members", "id");
//        return this.id.size();
//    }
}
