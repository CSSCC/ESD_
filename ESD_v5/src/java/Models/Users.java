package Models;

import Models.Jdbc;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users {

    ArrayList<String> id;
    ArrayList<String> password;
    ArrayList<String> status;

    public Users() throws SQLException {
        id = Jdbc.runQuery("SELECT * FROM users", "id");

        password = Jdbc.runQuery("SELECT * FROM users", "password");

        status = Jdbc.runQuery("SELECT * FROM users", "status");

    }

    public String getId(int index) throws SQLException {

        id = Jdbc.runQuery("SELECT * FROM users", "id");
        String individual_id = id.get(index);

        return individual_id;
    }

    public String getPassword(int index) throws SQLException {

        password = Jdbc.runQuery("SELECT * FROM users", "password");
        String individual_password = password.get(index);

        return individual_password;
    }

    public String getStatus(int index) throws SQLException {

        status = Jdbc.runQuery("SELECT * FROM users", "status");
        String individual_status = status.get(index);

        return individual_status;
    }

//    public int getMembersSize() throws SQLException {
//        id = Jdbc.runQuery("SELECT * FROM members", "id");
//        return this.id.size();
//    }
}
