package database;

import beans.Properties;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alan.ryan
 */
public class PropertiesDB {

    private static final ArrayList<Properties> propertiesList = new ArrayList();

    
    ////////////////////////////////////////////////////////////////////////////////////
    //returns an ArrayList of Properties objects
    ////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<Properties> getPropertiesList() {

        propertiesList.clear();

        String query = "SELECT * FROM properties";

        try {
            JdbcRowSetImpl rowSet = DBConnection.getRowSet();
            rowSet.setCommand(query);
            rowSet.execute();

            while (rowSet.next()) {

                Properties p = new Properties();
                p.setId(rowSet.getInt("id"));
                p.setBathrooms(rowSet.getString("bathrooms"));
                p.setBedrooms(rowSet.getString("bedrooms"));
                p.setDescription(rowSet.getString("description"));
                p.setPhoto(rowSet.getString("photo"));
                p.setPrice(rowSet.getDouble("price"));
                p.setSquareFootage(rowSet.getString("squarefeet"));
                p.setStreet(rowSet.getString("street"));

                propertiesList.add(p);

            }//end while

        }//end try
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error retrieving property list " + ex.toString());
            DBConnection.disconnect();
            System.exit(0);
        }//end catch

        return propertiesList;

    }//end getPropertiesList()   

    
    ////////////////////////////////////////////////////////////////////////////////////
    //returns the total value of all prices in the properties table 
    ////////////////////////////////////////////////////////////////////////////////////
    public static double getTotalPrices() {

        String sql = "SELECT SUM(price) AS totalPrice FROM Properties";
       
        try {
            JdbcRowSetImpl rowSet = DBConnection.getRowSet();
            rowSet.setCommand(sql);
            rowSet.execute();
            rowSet.next();

            return rowSet.getDouble("totalPrice");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            DBConnection.disconnect();
            System.exit(0);
        }//end catch

        return 0.0; //there's a problem if we get to here
    
    }//end method getTotalPrices()

    
    ////////////////////////////////////////////////////////////////////////////////////
    //returns a formatted and sorted (by dateAdded) list of properties and their style 
    //based on the selected agent
    ////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList getPropertiesAndAgentsFormatted(String username) {
       
        ArrayList<String> pList = new ArrayList();
        DecimalFormat df = new DecimalFormat("€#,###,##0.00");


        String sql =   "SELECT p.id, p.street, p.city, p.bathrooms, p.bedrooms, p.price,"
                       + "p.agentId, p.dateAdded, a.username, s.styleId, s.pStyle "
                       + "FROM properties p "
                       + "INNER JOIN styles s "
                       + "on p.styleId = s.styleId "
                       + "INNER JOIN agents a "
                       + "on p.agentId = a.agentId WHERE a.username = '" + username + "' "
                       + "ORDER BY p.dateAdded ASC";
        try {
            JdbcRowSetImpl rowSet = DBConnection.getRowSet();
            rowSet.setCommand(sql);
            rowSet.execute();

            while (rowSet.next()) {

                String s = String.format("%-4s%-55s%-15s%-15s%-10s%-15s%-20s%-10s",
                        rowSet.getString("id"),
                        rowSet.getString("street"),
                        rowSet.getString("city"),
                        rowSet.getString("bathrooms"),
                        rowSet.getString("bedrooms"),
                        df.format(rowSet.getDouble("price")),
                        rowSet.getString("pStyle"),
                        rowSet.getDate("dateAdded"));

                pList.add(s);

            }//end while

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            DBConnection.disconnect();
            System.exit(0);
        }//end catch
        
        return pList;

    }//end method getPropertiesAndAgentsFormatted()
    
    ////////////////////////////////////////////////////////////////////////////////////

}//end class PropertiesDB
