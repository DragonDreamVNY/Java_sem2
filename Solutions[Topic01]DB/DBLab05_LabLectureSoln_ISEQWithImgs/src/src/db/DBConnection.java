package src.db;

import com.sun.rowset.JdbcRowSetImpl;
import javax.swing.JOptionPane;

public class DBConnection {

    static JdbcRowSetImpl rowSet;

    public static void doConnection() {

        rowSet = new JdbcRowSetImpl();

        try {

            rowSet.setUrl("jdbc:mysql://localhost:3306/iseq");
            rowSet.setUsername("sduser");
            rowSet.setPassword("pass");
            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Creating Connection " + ex);
            System.exit(0);
        }

    }

    public static void closeConnection() {
        try {
            rowSet.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Closing Connection " + ex);
            System.exit(0);
        }
    }
    
    public static JdbcRowSetImpl getAllRecords() {
        
        try {
            rowSet.setCommand("SELECT * FROM prices");
            rowSet.execute();
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Creating Connection " + ex);
            System.exit(0);
        }
        
        return rowSet;
        
    }

}
