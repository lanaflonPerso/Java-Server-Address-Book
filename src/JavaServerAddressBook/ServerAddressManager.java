package JavaServerAddressBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Tomov on 29.11.2016 г..
 */
public class ServerAddressManager {
    private ConnectionHelp conn;
    public ServerAddressManager() {
        conn = new ConnectionHelp();
    }
    public ArrayList<Person> getAll() {
        return conn.executeQuery("SELECT * FROM `people`",0);
    }
    public ArrayList<Person> searchFor (String name) {
        return conn.executeQuery("SELECT * FROM `people` WHERE `name` LIKE '%" + name + "%'",0);
    }
    public void addInDb (Person p) {
        String sql = "INSERT INTO `people` (`name`, `address`, `phone`, `email`, `comment`) VALUES ('" + p.getName() + "', '" + p.getAddress() + "', '" + p.getPhone() + "', '" + p.getEmail() + "', '" + p.getComment() +"');";
        conn.executeQuery(sql,1);
    }
    public void removeFromDb (Person p) {
        String sql = "DELETE FROM `people` WHERE name LIKE '" + p.getName() + "' AND address LIKE '" + p.getAddress() + "' AND phone LIKE '" + p.getPhone() + "' AND email LIKE '" + p.getEmail() + "' AND comment LIKE '" + p.getComment() + "'; ";
        conn.executeQuery(sql,1);
    }
}


//"SELECT * FROM `people` WHERE `name` LIKE '%" + name + "%'"
