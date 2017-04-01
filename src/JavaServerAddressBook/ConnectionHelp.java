package JavaServerAddressBook;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Tomov on 29.11.2016 г..
 */
public class ConnectionHelp {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/adressbook";
    private static final String USER = "Dimitar";
    private static final String PASS = "123456";
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static ConnectionHelp connReference;
    private ConnectionHelp() {
        registerJDBC();
        openConn();
        prepareStatement();
    }
    public static ConnectionHelp getInstance()  {
        if(connReference==null) {
            connReference = new ConnectionHelp();
        }
        return connReference;
    }
    private void registerJDBC() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    private void openConn() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void prepareStatement() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Person> executeQuery(String sql, int operation) {
        ArrayList<Person> people = new ArrayList<Person>();
        int res;
        try {
            if(operation == 0) {
                rs = stmt.executeQuery(sql);

                Person p = null;

                while (rs.next()) {
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String comment = rs.getString("comment");
                    p = new Person(name, address, phone, email, comment);
                    people.add(p);
                }
            }
            else if(operation == 1)
                res = stmt.executeUpdate(sql);
            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return people;
    }


    @Override
    public void finalize(){
//finally block used to close resources
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
        }// nothing we can do
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }//end finally try
    }

}
