package test;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Main {

    static boolean firstTime =false;
    
    public static Connection connectDB(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://localhost:1433;databasename=Login";
            Connection con =DriverManager.getConnection(connectionURL,"sa","12345");
            if (firstTime==false) {
                JOptionPane.showMessageDialog(null, "Successfully Connected", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                firstTime = true;
            }
            return con;
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error", "Internal Problem",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    

}
