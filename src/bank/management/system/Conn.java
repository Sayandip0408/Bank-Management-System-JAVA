package bank.management.system;

import java.sql.*;

/**
 *
 * @author sayandipadhikary
 */
public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","pass1234");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
