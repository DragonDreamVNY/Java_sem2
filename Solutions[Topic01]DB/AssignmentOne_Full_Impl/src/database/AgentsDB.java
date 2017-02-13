package database;

import beans.Agents;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AgentsDB {

    private static final ArrayList<String> agentsUsernameList = new ArrayList();

    ////////////////////////////////////////////////////////////////////////////////////
    //returns an Agents object based on the userName passed to this method
    ////////////////////////////////////////////////////////////////////////////////////
    public static Agents getAnAgent(String userName) {

        Agents a = new Agents();

        try {

            JdbcRowSetImpl rowSet = DBConnection.getRowSet();
            rowSet.setCommand("SELECT * from agents where username = '" + userName + "'");

            rowSet.execute();

            while (rowSet.next()) {

                a.setAgentID(rowSet.getInt("agentId"));
                a.setName(rowSet.getString("name"));
                a.setUsername(rowSet.getString("userName"));
                a.setPassword(rowSet.getString("password"));
                a.setEmail(rowSet.getString("email"));
                a.setPhone(rowSet.getString("phone"));
                a.setFax(rowSet.getString("fax"));
                a.setAgentImage(rowSet.getString("agentImage"));

            }//end while
        }//end try
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error retrieving agent details " + ex.toString());
            DBConnection.disconnect();
            System.exit(0);
        }//end catch

        return a;
    }//end method getAnAgent()

    

    ////////////////////////////////////////////////////////////////////////////////////
    //returns an ArrayList of Strings - each string containing a different agent username
    ////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<String> getAgentsList() {
        try {

            JdbcRowSetImpl rowSet = DBConnection.getRowSet();
            rowSet.setCommand("SELECT username from agents");

            rowSet.execute();

            while (rowSet.next()) {

                agentsUsernameList.add(rowSet.getString("username"));
            }//end while

        }//end try 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error retrieving usernames " + ex.toString());
            DBConnection.disconnect();
            System.exit(0);
        }//end catch

        return agentsUsernameList;

    }//end getAgentsList
    ////////////////////////////////////////////////////////////////////////////////////

}//end class
