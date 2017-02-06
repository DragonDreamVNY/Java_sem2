package GUI;

import beans.Properties;
import database.AgentsDB;
import database.DBConnection;
import database.PropertiesDB;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Alan.Ryan
 */
public class MainFrame extends javax.swing.JFrame {

    boolean initPhase = true;

    ArrayList<Properties> props;

    DecimalFormat df = new DecimalFormat("€#,###,##0.00");

    public MainFrame() {

        //set up the GUI
        initComponents();

        //connect to db
        DBConnection.connectToDB();

        //get an array list of all the user names in the DB
        ArrayList<String> userNames = AgentsDB.getAgentsList();

        //iterate over the arraylist and add each of them to the combobox
        for (String aUser : userNames) {
            agentsComboBox.addItem(aUser);
        }//end for

        //indicate that the combobox is full of agent usernames
        initPhase = false;
        
    }//end construtor

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        agentsPanel = new javax.swing.JPanel();
        agentsComboBox = new javax.swing.JComboBox();
        totalPricePanel = new javax.swing.JPanel();
        totalHousePriceButton = new javax.swing.JButton();
        printDetailsPanel = new javax.swing.JPanel();
        printDetailsButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Frame");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        agentsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Agents"));
        agentsPanel.setLayout(new java.awt.BorderLayout());

        agentsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agentsComboBoxActionPerformed(evt);
            }
        });
        agentsPanel.add(agentsComboBox, java.awt.BorderLayout.CENTER);

        getContentPane().add(agentsPanel);

        totalPricePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Total House Price"));
        totalPricePanel.setLayout(new java.awt.BorderLayout());

        totalHousePriceButton.setText("Display Total Price Of All Houses");
        totalHousePriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalHousePriceButtonActionPerformed(evt);
            }
        });
        totalPricePanel.add(totalHousePriceButton, java.awt.BorderLayout.CENTER);

        getContentPane().add(totalPricePanel);

        printDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Print Details"));
        printDetailsPanel.setLayout(new java.awt.BorderLayout());

        printDetailsButton.setText("Print Property Details");
        printDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printDetailsButtonActionPerformed(evt);
            }
        });
        printDetailsPanel.add(printDetailsButton, java.awt.BorderLayout.CENTER);

        getContentPane().add(printDetailsPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printDetailsButtonActionPerformed

        String username = (String) agentsComboBox.getSelectedItem();
      
        //create textarea and set a font for it
        JTextArea jta = new JTextArea();
        jta.setFont(new Font("Courier New", Font.PLAIN, 12));

        //make sure text area can't be edited
        jta.setEditable(false);

        
        //get an array list of all the props in the table that match the selected username
        ArrayList<String> list = PropertiesDB.getPropertiesAndAgentsFormatted(username);

        //create col headings
        String output = "Properties for " + username + "\n\n";
        output += String.format("%-4s%-55s%-15s%-15s%-10s%-15s%-20s%-10s", "ID", "Street", "City", "Baths", "Beds", "Price", "Style", "Date Added");

        output += "\n";

        //add each element of the arraylist (a formatted string) to the string output
        for (String aProp : list) {
            output += aProp + "\n";
        }//end for

        //put output in the text area
        jta.setText(output);

        //display the text area in a message box
        JOptionPane.showMessageDialog(null, jta);
    }//GEN-LAST:event_printDetailsButtonActionPerformed

    private void agentsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agentsComboBoxActionPerformed

        //this event handler will be called as a result of the agents being added to the combobox
        //without this check the second frame will be displayed at startup without
        //the user selecting an option from the list
        //this boolean ensures its only displayed as a result of a user selection
        if (initPhase) {
            return;
        }

        //get the selected id from the combobox
        String selectedUsername = agentsComboBox.getSelectedItem().toString();

        //create instance of second frame and pass the selected username to it 
        AgentDetailsFrame agentDisplay = new AgentDetailsFrame(selectedUsername);
        agentDisplay.setVisible(true);

    }//GEN-LAST:event_agentsComboBoxActionPerformed

    private void totalHousePriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalHousePriceButtonActionPerformed
        
        JOptionPane.showMessageDialog(null, "Total prices of all houses is " + df.format(PropertiesDB.getTotalPrices()));
    }//GEN-LAST:event_totalHousePriceButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        //this event handler is called when the user closes the main frame
        //its good practice to disconnect from the db
        System.out.println("Releasing resources");
        DBConnection.disconnect();
        System.out.println("App closed");
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox agentsComboBox;
    private javax.swing.JPanel agentsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton printDetailsButton;
    private javax.swing.JPanel printDetailsPanel;
    private javax.swing.JButton totalHousePriceButton;
    private javax.swing.JPanel totalPricePanel;
    // End of variables declaration//GEN-END:variables
}