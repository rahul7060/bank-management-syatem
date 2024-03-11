import java.sql.*;

// jdbc connection is done at here

public class conn {
    Connection c;
    Statement s;
    public conn(){ //constructor
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Rahul@10");
            s = c.createStatement();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}