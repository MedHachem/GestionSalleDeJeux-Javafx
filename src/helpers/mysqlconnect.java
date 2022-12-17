
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class mysqlconnect {
    public static Connection ConnectDb(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/salledejeux","root","" );
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "probléme de cnx");
            return null;
        } 
    }
}
