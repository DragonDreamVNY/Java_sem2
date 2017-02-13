package database;

import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alan.ryan
 */
public class DBConnection {
    
    private static JdbcRowSetImpl rowSet;
    
    
    ////////////////////////////////////////////////////////////////////////////////////
    //connect to the db
    ////////////////////////////////////////////////////////////////////////////////////
     public static void connectToDB() {
        try {
              rowSet = new JdbcRowSetImpl();

               getRowSet().setUrl("jdbc:mysql://localhost:3306/litrealty");
               getRowSet().setUsername("root");
               getRowSet().setPassword("root"); //set to "" on windows, is "root" on MAMP

           }//end try
           catch(SQLException sqlex) {
               JOptionPane.showMessageDialog(null, "Error in connection " + sqlex.toString());

           }//end catch
        
    }//end connectToDB()

    
    ////////////////////////////////////////////////////////////////////////////////////
    //disconnect from the db
    ////////////////////////////////////////////////////////////////////////////////////
     public static void disconnect() {
        try {
            getRowSet().close();
        }//end try
        catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error disconnecting " + ex.toString());
        }//end catch
       
    }//end disconnect()

    
    ////////////////////////////////////////////////////////////////////////////////////
    //returns the rowSet
    ////////////////////////////////////////////////////////////////////////////////////
    public static JdbcRowSetImpl getRowSet() {
            return rowSet;
    }//end method getRowSet()
    
    ////////////////////////////////////////////////////////////////////////////////////
 
}//end class DBConnection