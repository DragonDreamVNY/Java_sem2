package src;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Alan.Ryan
 */
public class MainFrame extends javax.swing.JFrame {

    private ResultSet resultSet;
    private Statement statement;
    private Connection connection;
    private DecimalFormat df = new DecimalFormat("#,###,###.00");
    private JTextArea jta = new JTextArea();

    public MainFrame() {
        initComponents();
        
        jta.setFont(new java.awt.Font("Monospaced", 0, 12));
        
        jta.setEditable(false);
        
        doConnection();

        try {
            
            String query = "SELECT username  FROM agents";
           
            resultSet = statement.executeQuery(query);
            
            checkForEmptyResultSet();

            while (resultSet.next()) {
                agentsComboBox.addItem(resultSet.getString(1));
            }

        } catch (SQLException sqlex) {
            System.out.println("ERROR" + sqlex);
        }

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        agentsComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        totalPriceButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        printDetailsButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Working With Realty DB");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(4, 1, 10, 10));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agents"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.add(agentsComboBox, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Total House Price"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        totalPriceButton.setText("Display Total Price Of All Houses");
        totalPriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPriceButtonActionPerformed(evt);
            }
        });
        jPanel2.add(totalPriceButton, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Print Details"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        printDetailsButton.setText("Print Property Details");
        printDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printDetailsButtonActionPerformed(evt);
            }
        });
        jPanel4.add(printDetailsButton, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Do Insert"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        insertButton.setText("Do Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });
        jPanel5.add(insertButton, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printDetailsButtonActionPerformed
        try {

            String formattedOutput = "";
            
            String query =  "SELECT Properties.street, Properties.city, Properties.description, Properties.price, "
                          + "Agents.name, Agents.phone "
                          + "FROM Properties INNER JOIN Agents ON Properties.agentId = Agents.agentId ORDER BY Properties.city ASC";
            
            resultSet = statement.executeQuery(query);
            
            checkForEmptyResultSet();

            String colHeads =  String.format("%-22s%-10s%-12s%-18s%-10s%-50s", "Street", "City", "Price", "Agent", "Contact", "Description");
            jta.append(colHeads +"\n");
            
            while (resultSet.next()) {

                String street = resultSet.getString("street");  
                String city = resultSet.getString("city");
                String desc = resultSet.getString("description");
                String price = df.format(resultSet.getDouble("price"));
                String agentName = resultSet.getString("name");
                String agentPhone = resultSet.getString("phone");
                
                
                formattedOutput = String.format("%-22s%-10s%-12s%-18s%-10s%-50s", street,city,price,agentName,agentPhone, desc);
     
                jta.append(formattedOutput + "\n");
           
            } 
            
            
        
            JOptionPane.showMessageDialog(null, jta);
            
            jta.setText("");
            
        }//end try
        catch (SQLException ex) {
            System.out.println("ERROR " + ex);
        }

    }//GEN-LAST:event_printDetailsButtonActionPerformed

    private void totalPriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPriceButtonActionPerformed

        try {
           
            resultSet = statement.executeQuery("SELECT SUM(price) AS totalHousePrice FROM properties");

            checkForEmptyResultSet();
            
            resultSet.next();
            
            JOptionPane.showMessageDialog(this, "The total price of all the houses are: €" + df.format(resultSet.getObject(1)));

        } catch (SQLException sqlex) {
            System.out.println("ERROR" + sqlex);
        }

    }//GEN-LAST:event_totalPriceButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed

        //this insert assumes that the property id is set to auto increment in the db
        
        String street = JOptionPane.showInputDialog("Enter street");
        String city = JOptionPane.showInputDialog("Enter city");
        String desc = JOptionPane.showInputDialog("Enter description");
        String beds = JOptionPane.showInputDialog("Enter number of beds");
        String baths = JOptionPane.showInputDialog("Enter number of baths");
        String agent = JOptionPane.showInputDialog("Enter ID of Agent Responsible For Selling This Property");
        String price = JOptionPane.showInputDialog("Enter The Price for This Property");
        
        
        
        int numberOfBeds = Integer.parseInt(beds);
        int numberOfBaths = Integer.parseInt(baths);
        int agentID = Integer.parseInt(agent);
        double propPrice = Double.parseDouble(price);
        
        
        try {

            PreparedStatement pstmt = connection.prepareStatement("INSERT into Properties(street, city, description, bedrooms, bathrooms, agentId, price) values (?, ?, ?, ?, ?, ? ,?)");
            pstmt.setString(1, street);
            pstmt.setString(2, city);
            pstmt.setString(3, desc);
            pstmt.setInt(4, numberOfBeds);
            pstmt.setInt(5, numberOfBaths);
            pstmt.setInt(6, agentID);
            pstmt.setDouble(7, propPrice);
                 
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Insert done");
                    
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
        

    }//GEN-LAST:event_insertButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeConnection();
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
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton printDetailsButton;
    private javax.swing.JButton totalPriceButton;
    // End of variables declaration//GEN-END:variables

    private void doConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/litrealty", "root", "");
             statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem Opening DB Connection \n" + ex );
        }
    }
    
    private void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem Closing DB Connection \n" + ex );
        }
        
        
    }

    private void checkForEmptyResultSet() {
        try {
            if (!resultSet.next()) {
                   JOptionPane.showMessageDialog(null, "No results");
                   return;
               }
               
               resultSet.beforeFirst();
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex);
        }
    }
}
