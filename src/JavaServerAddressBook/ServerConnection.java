/**
 * Created by Tomov on 28.11.2016 г..
 */
package JavaServerAddressBook;

import java.sql.*;
import java.util.ArrayList;
public class ServerConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/adressbook";
    private String user;
    private String password;
    private Connection conn = null;
    private Statement stmt = null;

    public ServerConnection(String user, String password) {
        this.user = user;
        this.password = password;
        registerJDBC();
    }

    private void registerJDBC() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    private void openConnection() throws SQLException {
        conn = DriverManager.getConnection(DB_URL,user,password);
    }
    public Person getPersonFromServer(int id) {
        // SELECT * FROM `people` WHERE `id` LIKE id
        try {
            openConnection();
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM `people` WHERE `id` LIKE " + id;
            ResultSet rs = stmt.executeQuery(sql);
            Person result = getPerson(rs);
            rs.close();
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
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
        return null;
    }
    private Person getPerson(ResultSet rs) throws SQLException {
        Person p = null;
        if(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String comment = rs.getString("comment");
            p = new Person(id, name, address, phone, email, comment);
        }
        return p;
    }
}

